package ChatRoom.server;

import ChatRoom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class Participant implements Runnable {

    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private String name;
    private Chat server;

    Participant(ObjectOutputStream outStream, ObjectInputStream inStream, String name, Chat server) {
        this.outStream = outStream;
        this.inStream = inStream;
        this.name = name;
        this.server = server;
    }

    String getName() {
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
        } catch (IOException e) {
            System.out.println(name + " disconnected!");
            server.deleteParticipant(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object obj) {
        try {
            outStream.writeObject(obj);
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return outStream.equals(that.outStream) &&
                inStream.equals(that.inStream) &&
                name.equals(that.name) &&
                server.equals(that.server);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outStream, inStream, name, server);
    }
}
