package ChatRoom.client.view.login;

import javax.swing.*;
import java.awt.*;

class ServerConfigPanel extends JPanel {

    private JTextField hostField = new JTextField();
    private JTextField portField = new JTextField();

    ServerConfigPanel() {

        JPanel hostPanel = new JPanel(new BorderLayout());
        hostPanel.add(new JLabel("Host:"), BorderLayout.PAGE_START);
        hostPanel.add(hostField, BorderLayout.CENTER);

        JPanel portPanel = new JPanel(new BorderLayout());
        portField.setEditable(false);
        portPanel.add(new JLabel("Port:"), BorderLayout.PAGE_START);
        portPanel.add(portField, BorderLayout.CENTER);
        portPanel.setPreferredSize(new Dimension(50, 0));

        this.setLayout(new BorderLayout());
        this.add(hostPanel, BorderLayout.CENTER);
        this.add(portPanel, BorderLayout.EAST);

        this.setPreferredSize(new Dimension(LoginView.WIDTH, 40));

        this.setVisible(true);

    }

    JTextField getHostField() {
        return hostField;
    }

    JTextField getPortField() {
        return portField;
    }
}
