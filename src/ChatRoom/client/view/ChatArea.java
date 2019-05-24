package ChatRoom.client.view;

import javax.swing.*;

public class ChatArea extends JTextArea {

    private static final int ROWS = 10, COLUMNS = 30;

    public ChatArea() {
        super(ROWS, HEIGHT);
        this.setEditable(false);
        this.setLineWrap(true);
    }

    public void addMessage(String username, String message) {
        this.setText(this.getText() + username + ":\n" + message + "\n");

    }


}
