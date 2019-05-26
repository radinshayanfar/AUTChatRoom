package ChatRoom.client.controller;

import ChatRoom.client.model.Server;
import ChatRoom.client.view.UsernameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private UsernameFrame view;
    private Server server;

    public LoginController(Server server) {
        this.server = server;
        view = new UsernameFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = view.getJTextFieldText();
        if (username.length() == 0) return;
        view.dispose();
        new ChatController(username, server);

    }

}
