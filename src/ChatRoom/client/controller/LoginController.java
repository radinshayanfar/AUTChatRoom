package ChatRoom.client.controller;

import ChatRoom.client.model.ServerConfig;
import ChatRoom.client.view.login.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private LoginView view;

    public LoginController(ServerConfig serverConfig) {
        view = new LoginView(this, serverConfig);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = view.getUsername();
        if (username.length() == 0) return;
        if (view.getHost().length() == 0) return;
        view.dispose();
        new ChatController(username, new ServerConfig(view.getHost(), view.getPort()));

    }

}
