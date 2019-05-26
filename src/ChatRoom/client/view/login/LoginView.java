package ChatRoom.client.view.login;

import ChatRoom.client.controller.LoginController;
import ChatRoom.client.model.ServerConfig;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    static final int WIDTH = 300, HEIGHT = 140;

    private UsernamePanel usernamePanel = new UsernamePanel();
    private ServerConfigPanel serverConfigPanel = new ServerConfigPanel();

    public LoginView(LoginController controller, ServerConfig serverConfig) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.add(usernamePanel);
        this.add(serverConfigPanel);

        JButton startChat = new JButton("Start Chat");
        this.add(startChat);

        serverConfigPanel.getHostField().setText("" + serverConfig.getHost());
        serverConfigPanel.getPortField().setText("" + serverConfig.getPort());
        startChat.addActionListener(controller);
        usernamePanel.getUsernameField().addActionListener(controller);
        serverConfigPanel.getHostField().addActionListener(controller);

        this.setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));
        this.setResizable(false);

        this.setVisible(true);
    }

    public String getUsername() {
        return usernamePanel.getUsernameField().getText();
    }

    public ServerConfig getServerConfig() {
        return serverConfigPanel.getServerConfig();
    }
}