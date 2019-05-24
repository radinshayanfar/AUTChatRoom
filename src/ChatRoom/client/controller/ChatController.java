package ChatRoom.client.controller;

import ChatRoom.Message;
import ChatRoom.client.model.Server;
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
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;

    ChatController(String username, Server server) {

        view = new ChatRoomGUI(this, username);
        this.username = username;

        try {
            Socket socket = new Socket(server.getHost(), server.getPort());
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());

            outStream.writeObject(username);
            outStream.flush();
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

    void addNewMessage(Message message) {
        view.addNewMessage(message.getUsername(), message.getText());
    }

    void setParticipants(String[] participants) {
        view.setParticipant(participants);
    }
}
