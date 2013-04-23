package vn.edu.rmit.sadi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private String root;

    public static void main(String[] args) {
        new WebServer("C:\\").start();
    }

    private WebServer(String location) {
        this.root = location;
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket(8771);
            while (true) {
                Socket client = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(new BufferedOutputStream(client.getOutputStream()), true);
                while (true) {
                    System.out.println("Receiving request...");
                    String[] tokens = reader.readLine().split(" ");
                    handleRequest(tokens[0], tokens[1], writer);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleRequest(String method, String url, PrintWriter writer) throws FileNotFoundException, IOException {
        // only supports GET
        if (!(method.equalsIgnoreCase("GET"))) {
            writer.println("Unsupported HTTP method");
            writer.println("END");
            return;
        }
        String absolutePath = root + url;
        File file = new File(absolutePath);
        // this is 404 - Not Found
        if (!file.exists()) {
            writer.println("Resource does not exist");
            writer.println("END");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null)
            writer.println(line);
        writer.println("END");
    }

}
