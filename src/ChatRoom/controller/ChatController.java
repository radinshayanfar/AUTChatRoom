package ChatRoom.controller;

import ChatRoom.view.ChatRoomGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatController implements ActionListener {

    private ChatRoomGUI view;
    private String username;

    public ChatController(String username) {

        view = new ChatRoomGUI(this);
        this.username = username;
        view.addNewParticipant(username);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.addNewMessage(username, view.getJTextFieldText());
        view.resetMessageText();
    }
}
