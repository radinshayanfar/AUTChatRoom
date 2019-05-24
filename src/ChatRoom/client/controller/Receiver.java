package ChatRoom.client.controller;


import ChatRoom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver implements Runnable {

    private ObjectInputStream inStream;
    private ChatController controller;

    Receiver(ObjectInputStream inStream, ChatController controller) {
        this.inStream = inStream;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object readObj = inStream.readObject();
                if (readObj instanceof Message) {
                    Message message = (Message) readObj;
                    controller.addNewMessage(message);
                }
                if (readObj instanceof String[]) {
                    String[] list = (String[]) readObj;
                    controller.setParticipants(list);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
