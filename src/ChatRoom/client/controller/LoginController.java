package ChatRoom.client.controller;

import ChatRoom.client.model.ServerConfig;
import ChatRoom.client.view.login.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LoginController implements ActionListener {

    private LoginView view;

    public LoginController(ServerConfig serverConfig) {
        view = new LoginView(this, serverConfig);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = view.getUsername();
        if (username.length() == 0) return;

        ServerConfig serverConfig = view.getServerConfig();
        if (serverConfig.getHost().length() == 0) return;

        try {
            view.disableFieldsForConnection();

            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(serverConfig.getHost(), serverConfig.getPort()), 10_000);
            view.dispose();
            new ChatController(socket, username);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Host unreachable");
            view.enableFieldsAfterConnectionFailed();
        }
    }

}
