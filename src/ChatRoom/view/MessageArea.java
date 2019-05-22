package ChatRoom.view;

import ChatRoom.controller.ChatController;

import javax.swing.*;
import java.awt.*;

public class MessageArea extends JPanel {

    private JButton send;
    private JTextField text;

    public MessageArea(ChatController controller) {
        super(new BorderLayout());
        send = new JButton("Send");
        send.addActionListener(controller);
        this.add(send, BorderLayout.EAST);
        text = new JTextField();
        text.setBackground(Color.pink);
        text.addActionListener(controller);
        this.add(text, BorderLayout.CENTER);

    }

    public String getJTextFieldText() {
        return text.getText();
    }

    public void reset() {
        text.setText("");
    }
}
