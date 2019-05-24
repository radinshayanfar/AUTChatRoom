package ChatRoom.client.controller;

import ChatRoom.Message;
import ChatRoom.client.view.ChatRoomGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatController implements ActionListener {

    private ChatRoomGUI view;
    private String username;
    private Socket socket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;

    public ChatController(String username) {

        view = new ChatRoomGUI(this);
        this.username = username;

        try {
            socket = new Socket("127.0.0.1", 8749);
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());

            outStream.writeObject(username);
            view.addNewParticipant(username);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        new Thread(new Receiver(inStream, this)).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            outStream.writeObject(new Message(username, view.getJTextFieldText()));
            outStream.flush();
            view.resetMessageText();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addNewMessage(Message message) {
        view.addNewMessage(message.getUsername(), message.getText());
    }
}
