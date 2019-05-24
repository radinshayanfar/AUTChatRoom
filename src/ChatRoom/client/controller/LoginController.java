package ChatRoom.client.controller;

import ChatRoom.client.view.UsernameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private UsernameFrame view;

    public LoginController() {
        view = new UsernameFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = view.getJTextFieldText();
        view.dispose();
        new ChatController(username);

    }

}
