package vn.edu.rmit.sadi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class DbThread implements Runnable {

    private Log log = LogFactory.getLog(DbThread.class);

    private MessageDao dao;
    private Socket client;

    public void setDao(MessageDao dao) {
        this.dao = dao;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());

            while(true) {
                // get message from client
                String message = dis.readUTF();
                log.info("Received : "+message);
                // write to db
                dao.saveMessage(message);

                StringBuffer sb = new StringBuffer();
                // show all messages
                for(String m : dao.allMessages()) {
                    sb.append(m);
                    sb.append("\n");
                }
                dos.writeUTF(sb.toString());
                dos.flush();
            }

        } catch(Exception e) {
            e.printStackTrace();
            log.error(e);
        }
    }
}
