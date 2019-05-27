package ChatRoom.client.view.login;

import ChatRoom.client.controller.LoginController;
import ChatRoom.client.model.ServerConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        serverConfigPanel.getHostField().setText(serverConfig.getHost());
        serverConfigPanel.getPortField().setText(String.valueOf(serverConfig.getPort()));
        startChat.addActionListener(controller);
        usernamePanel.getUsernameField().addActionListener(controller);
        serverConfigPanel.getHostField().addActionListener(controller);

        this.setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));
        this.setResizable(false);

        this.setFocusTraversalPolicy(new MyFocusTraversalPolicy(usernamePanel.getUsernameField(), serverConfigPanel.getHostField(), startChat));

        this.setVisible(true);
    }

    public String getUsername() {
        return usernamePanel.getUsernameField().getText();
    }

    public ServerConfig getServerConfig() {
        return serverConfigPanel.getServerConfig();
    }

    public void disableFieldsForConnection() {
        usernamePanel.getUsernameField().setEnabled(false);
        serverConfigPanel.getHostField().setEnabled(false);
        serverConfigPanel.getPortField().setEnabled(false);
    }

    public void enableFieldsAfterConnectionFailed() {
        usernamePanel.getUsernameField().setEnabled(true);
        serverConfigPanel.getHostField().setEnabled(true);
        serverConfigPanel.getPortField().setEnabled(true);
    }

    private static class MyFocusTraversalPolicy extends FocusTraversalPolicy {

        private List<Component> list = new ArrayList<>();

        public MyFocusTraversalPolicy(Component... components) {
            list.addAll(Arrays.asList(components));
        }

        @Override
        public Component getComponentAfter(Container aContainer, Component aComponent) {
            int index = list.indexOf(aComponent);
            return list.get((index + 1) % list.size());
        }

        @Override
        public Component getComponentBefore(Container aContainer, Component aComponent) {
            int index = list.indexOf(aComponent);
            return index == 0 ? list.get(list.size() - 1) : list.get(index - 1);
        }

        @Override
        public Component getFirstComponent(Container aContainer) {
            return list.get(0);
        }

        @Override
        public Component getLastComponent(Container aContainer) {
            return list.get(list.size() - 1);
        }

        @Override
        public Component getDefaultComponent(Container aContainer) {
            return list.get(0);
        }
    }
}