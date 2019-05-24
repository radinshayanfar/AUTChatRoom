package ChatRoom.server;

import ChatRoom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Participant implements Runnable {

    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private String name;
    private Chat server;

    public Participant(ObjectOutputStream outStream, ObjectInputStream inStream, String name, Chat server) {
        this.outStream = outStream;
        this.inStream = inStream;
        this.name = name;
        this.server = server;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) inStream.readObject();
                System.out.println("User: " + message.getUsername() + "\nText: " + message.getText());
                server.sendMessageToAll(message);

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message message) {
//        System.out.println(message.getText());
        try {
            outStream.writeObject(message);
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
