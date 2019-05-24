package ChatRoom.client.controller;


import ChatRoom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver implements Runnable {

    private ObjectInputStream inStream;
    private ChatController controller;

    public Receiver(ObjectInputStream inStream, ChatController controller) {
        this.inStream = inStream;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) inStream.readObject();
                controller.addNewMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
