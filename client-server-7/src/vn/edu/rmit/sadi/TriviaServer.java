package vn.edu.rmit.sadi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TriviaServer {

    private Map<String, String> qaMap = new HashMap<String, String>();
    private int clientCount = 0;

    public static void main(String[] arguments) {
        new TriviaServer();
    }

    public TriviaServer() {
        initializeData();
        startServer();
    }

    private void initializeData() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("vn/edu/rmit/sadi/qa.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String key;
            while ((key = br.readLine()) != null) {
                qaMap.put(key, br.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startServer() {
        ServerSocket server;
        try {
            server = new ServerSocket(4415);
            System.out.println("TriviaServer is up and running ...");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        while (true) {
            try {
                new TriviaThread(server.accept()).start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private enum GameState {
        PrepareToSendQuestion,
        WaitForAnswer,
        WaitForConfirm
    }

    class TriviaThread extends Thread {
        private Socket client = null;
        private GameState state = GameState.PrepareToSendQuestion;
        private Iterator<Map.Entry<String, String>> entryIter;
        private Map.Entry<String, String> currentEntry;

        public TriviaThread(Socket sock) {
            super("TriviaThread");
            client = sock;
        }

        @Override
        public void run() {
            System.out.println("TriviaThread #" + ++clientCount + " started ...");
            try {
                BufferedReader reader = getReader();
                PrintWriter writer = getWriter();
                executeGameLoop(writer, reader);
                cleanUpResources(writer, reader);
            } catch (IOException ex) {}
        }

        private void executeGameLoop(PrintWriter writer, BufferedReader reader) throws IOException {
            String msgToClient = getMessageToClient(null);
            while (msgToClient != null) {
                writer.println(msgToClient);
                String msgFromClient = reader.readLine();
                msgToClient = getMessageToClient(msgFromClient);
            }
        }

        private String getMessageToClient(String msgFromClient) {
            switch (state) {
                case PrepareToSendQuestion:
                    state = GameState.WaitForAnswer;
                    return generateQuestion();
                case WaitForAnswer:
                    state = GameState.WaitForConfirm;
                    if (msgFromClient != null && msgFromClient.equalsIgnoreCase(currentEntry.getValue())) {
                        return "That's correct! Want another (y/n)?";
                    }
                    return "Wrong, the correct answer is " + currentEntry.getValue() + ". Want another (y/n)?";
                case WaitForConfirm:
                    if (msgFromClient != null && msgFromClient.equalsIgnoreCase("y")) {
                        state = GameState.WaitForAnswer;
                        return generateQuestion();
                    }
                    return null;
                default:
                    throw new RuntimeException("Invalid state");
            }
        }

        private String generateQuestion() {
            if (entryIter == null || !entryIter.hasNext()) {
                entryIter = qaMap.entrySet().iterator();
            }
            currentEntry = entryIter.next();
            return currentEntry.getKey();
        }

        private void cleanUpResources(PrintWriter writer, BufferedReader reader)
                throws IOException {
            writer.close();
            reader.close();
            client.close();
        }

        private BufferedReader getReader() throws IOException {
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            return new BufferedReader(isr);
        }

        private PrintWriter getWriter() throws IOException {
            return new PrintWriter(new BufferedOutputStream(client.getOutputStream()), true);
        }
    }
}