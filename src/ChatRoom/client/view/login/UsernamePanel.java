package ChatRoom.client.view.login;

import javax.swing.*;
import java.awt.*;

class UsernamePanel extends JPanel {

    private JTextField usernameField = new JTextField();

    UsernamePanel() {
        this.setLayout(new BorderLayout());
        add(new JLabel("Enter username:"), BorderLayout.PAGE_START);
        usernameField.setPreferredSize(new Dimension(LoginView.WIDTH, 30));
        add(usernameField, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(LoginView.WIDTH, 40));

        setVisible(true);
    }

    JTextField getUsernameField() {
        return usernameField;
    }

}
