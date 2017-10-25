

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client  {

    private Socket socket;

    private DataOutputStream dout;
    private DataInputStream din;
    public Client(String host, int port) {

        try {
            // Initiate the connection
            socket = new Socket(host,port);
            // We got a connection!
            System.out.println("connected to " + socket);
            // Let's grab the streams and create DataInput/Output streams
            // from them
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            // Start a background thread for receiving messages

            new ClientInPutThread(this);
            new ClientOutPutThread(this);
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    public DataInputStream getDin(){
        return din;
    }

    public DataOutputStream getDout(){
        return dout;
    }

    // Gets called when the user types something
    public void processMessage(String message) {
        try {
            // Send it to the server
            dout.writeUTF(message);
            // Clear out text input field

        } catch (IOException ie) {
            System.out.println(ie);
        }
    }



    public static void main(String agrs[]){
         new Client("39.108.158.170",5209);
    }

    //
    /**
     * @ClassName: ${ClientInPutThread}
     * @Description: ${To Input from System in}
     * @author Shen
     * @date ${2017.10.23} ${21:15}
     *
     */
    public class ClientInPutThread extends Thread {
        private Client client;
        private Scanner input = new Scanner(System.in);
        public ClientInPutThread(Client client){
            this.client = client;
            this.start();

        }


        public void run(){
            try {
                // Receive messages one-by-one, forever
                while (true) {
                    String  message = input.nextLine();
                    client.processMessage(message);
                }
            } catch (Exception ie) {
                System.out.println(ie);
            }
        }

    }

    /**
     * @ClassName: ${ClientOutPutThread}
     * @Description: ${To Output}
     * @author Shen
     * @date ${2017.10.23} ${21:15}
     *
     */
    public class ClientOutPutThread extends Thread {
        private Client client;
        private Scanner input = new Scanner(System.in);
        public ClientOutPutThread(Client client){
            this.client = client;
            this.start();

        }


        // Background thread runs this: show messages from other window
        public void run() {
            try {
                // Receive messages one-by-one, forever
                while (true) {
                    // Get the next message
                    String message = client.getDin().readUTF();

                    // Print it to our text window
                    System.out.println(message);
                }
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }

    }
}