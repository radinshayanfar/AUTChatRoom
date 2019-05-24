package ChatRoom.client.view;

import javax.swing.*;

class ChatArea extends JTextArea {

    private static final int ROWS = 10, COLUMNS = 30;

    ChatArea() {
        super(ROWS, COLUMNS);
        this.setEditable(false);
        this.setLineWrap(true);
    }

    void addMessage(String username, String message) {
        this.setText(this.getText() + username + ":\n" + message + "\n");

    }


}
