
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    // The Server that spawned us
    private Server server;
    // The Socket connected to our client
    private Socket socket;


    // Constructor.
    public ServerThread(Server server, Socket socket) {
        // Save the parameters
        this.server = server;
        this.socket = socket;
        // Start up the thread
        start();
    }

    // This runs in a separate thread when start() is called in the
    // constructor.
    public void run() {
        try {
            // Create a DataInputStream for communication; the client
            // is using a DataOutputStream to write to us
            ObjectInputStream din = new ObjectInputStream(socket.getInputStream());
            // Over and over, forever ...
            while (true) {


                Message message = (Message) din.readObject();
                // ... read the next message ...
                //String message = din.readUTF();

                if(message.getUser()==null){
                    message.setUser(setUserifNotUser());
                }

                // ... tell the world ...
                System.out.println(message);
                // ... and have the server send it to all clients
                server.sendToAll(message);
            }
        }catch (ClassNotFoundException ie){


        }
        catch (EOFException ie) {
            // This doesn't need an error message
        } catch (IOException ie) {
            // This does; tell the world!
            ie.printStackTrace();
        } finally {
            // The connection is closed for one reason or another,
            // so have the server dealing with it
            server.removeConnection(socket);
        }
    }

    public User setUserifNotUser(){
        User user  = new User();
        Message userMessage = new Message("");
        userMessage.setUser(user);
        userMessage.setMessageType(MessageType.REQUESTMESSAGE);
        try {
            server.sendtoS(socket,userMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}