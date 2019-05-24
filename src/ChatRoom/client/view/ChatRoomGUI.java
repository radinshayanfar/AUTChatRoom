package ChatRoom.client.view;

import ChatRoom.client.controller.ChatController;

import javax.swing.*;
import java.awt.*;

public class ChatRoomGUI extends JFrame {
    private static String WINDOWS_TITLE = "AUT Chat Room";
    private final int WIDTH = 500, HEIGHT = 500;
    private final int X = 300, Y = 200;
    private ChatArea chatBox;
    private MessageArea messageArea;
    private ParticipantsArea participantsArea;

    private ChatController controller;

    public ChatRoomGUI(ChatController controller) throws HeadlessException {
        super();
        this.controller = controller;
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);

        chatBox = new ChatArea();
        this.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        messageArea = new MessageArea(this.controller);
        this.add(messageArea, BorderLayout.SOUTH);

        participantsArea = new ParticipantsArea();
        participantsArea.setPreferredSize(new Dimension(170, participantsArea.getHeight()));
        this.add(participantsArea, BorderLayout.WEST);

        this.setVisible(true);



    }

    public void addNewMessage(String username, String message) {
        chatBox.addMessage(username, message);
    }

    public void addNewParticipant(String username) {
        participantsArea.addParticipant(username);
    }

    public void removeParticipant(String username) {
        participantsArea.removeParticipant(username);
    }

    public void resetMessageText() {
        messageArea.reset();
    }

    public String getJTextFieldText() {
        return messageArea.getJTextFieldText();
    }
}
