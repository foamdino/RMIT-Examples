package vn.edu.rmit.sadi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    // using apache commons logging - java also has a logging package (since 1.4.2)
    private Log log = LogFactory.getLog(Main.class);

    private ServerSocket server;
    private DbUtil dbUtil;
    private static ApplicationContext ctx;

    public static void main(String[] args) {

        ctx = new ClassPathXmlApplicationContext("spring-context.xml");

        Main m = ctx.getBean("main", Main.class);
        try {
            m.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public void setDbUtil(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    private void run() throws Exception {

        log.info("Before checking DB");
        dbUtil.createDb();
        log.info("After checking DB");

        log.info("Server started and waiting on client connections...");

        while(true) {
            Socket client = server.accept();
            log.info("Client connected...");
            DbThread t = ctx.getBean("dbThread", DbThread.class);
            t.setClient(client);
            new Thread(t).start();
        }
    }
}
