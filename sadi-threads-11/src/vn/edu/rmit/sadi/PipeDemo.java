package vn.edu.rmit.sadi;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

public class PipeDemo extends Thread {

    PipedOutputStream output;

    public PipeDemo(PipedOutputStream out) {
        output = out;
    }
    public void run() {
        try {
            // Create a printstream for convenient writing
            PrintStream p = new PrintStream(output);
            // Print message
            p.println("Hello from another thread, via pipes!");
            // close the stream
            p.close();
        }
        catch (Exception e) {
            System.err.println("Pipe error " + e);
        }
    }

    public static void main(String[] args) {
        try {
            PipedOutputStream pout = new PipedOutputStream();
            //Create a pipe for reading, and connect it to output pipe
            PipedInputStream pin = new PipedInputStream(pout);
            //create a new pipe demo thread, to write to our thread
            PipeDemo pipeDemo = new PipeDemo(pout);
            // start the thread
            pipeDemo.start();
            // read the thread data
            int input = pin.read();
            // Terminate when end of stream reached
            while (input != -1) {
                // Print the message
                System.out.print( (char) input);
                // read the next byte
                input = pin.read();
            }
        } catch (Exception e) {
            System.err.println("Pipe error " + e);
        }

    }
}
