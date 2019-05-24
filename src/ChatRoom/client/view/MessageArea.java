package ChatRoom.client.view;

import ChatRoom.client.controller.ChatController;

import javax.swing.*;
import java.awt.*;

class MessageArea extends JPanel {

    private JButton send;
    private JTextField text;

    MessageArea(ChatController controller) {
        super(new BorderLayout());
        send = new JButton("Send");
        send.addActionListener(controller);
        this.add(send, BorderLayout.EAST);
        text = new JTextField();
        text.setBackground(new Color(242, 242, 186));
        text.addActionListener(controller);
        this.add(text, BorderLayout.CENTER);

    }

    String getJTextFieldText() {
        return text.getText();
    }

    void reset() {
        text.setText("");
    }
}
