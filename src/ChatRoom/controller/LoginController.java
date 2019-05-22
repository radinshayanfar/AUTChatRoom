package ChatRoom.controller;

import ChatRoom.view.ChatRoomGUI;
import ChatRoom.view.UsernameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private UsernameFrame firstView;
    private ChatRoomGUI chatView;

    public LoginController() {
        firstView = new UsernameFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = firstView.getJTextFieldText();
        firstView.dispose();
        new ChatController(username);

    }

}
