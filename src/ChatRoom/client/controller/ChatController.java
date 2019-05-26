package ChatRoom.client.controller;

import ChatRoom.Message;
import ChatRoom.client.model.ServerConfig;
import ChatRoom.client.view.chatroom.ChatRoomView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatController implements ActionListener {

    private ChatRoomView view;
    private String username;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;

    ChatController(String username, ServerConfig serverConfig) {

        view = new ChatRoomView(this, username);
        this.username = username;

        try {
            Socket socket = new Socket(serverConfig.getHost(), serverConfig.getPort());
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
            if (view.getJTextFieldText().length() == 0) return;
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
