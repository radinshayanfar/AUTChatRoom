package ChatRoom;

import java.io.Serializable;

public class Message implements Serializable {
    private String username;
    private String text;

    public Message(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }
}
