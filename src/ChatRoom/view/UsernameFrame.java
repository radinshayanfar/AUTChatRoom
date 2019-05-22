package ChatRoom.view;

import ChatRoom.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class UsernameFrame extends JFrame {
    private static final String BTN_TXT = "Start Chatting ...";
    private static final String LABEL_TXT = "Choose Your UserName";
    private static final int WIDTH = 300, HEIGHT = 100;

    private LoginController controller;

    private JTextField textField;
    private JButton btn;

    public UsernameFrame(LoginController controller) throws HeadlessException {
        super();
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(LABEL_TXT);
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        textField.addActionListener(controller);
        add(textField, BorderLayout.CENTER);
        btn = new JButton(BTN_TXT);
        btn.addActionListener(controller);
        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));
        setVisible(true);
    }

    public String getJTextFieldText() {
        return textField.getText();
    }
}