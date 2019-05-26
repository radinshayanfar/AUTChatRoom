package ChatRoom.client.view.chatroom;

import ChatRoom.client.controller.ChatController;

import javax.swing.*;
import java.awt.*;

public class ChatRoomView extends JFrame {
    private static String WINDOWS_TITLE = "AUT Chat Room";
    private final int WIDTH = 500, HEIGHT = 500;
    private final int X = 300, Y = 200;
    private ChatArea chatBox;
    private MessageArea messageArea;
    private ParticipantsArea participantsArea;

    private ChatController controller;

    public ChatRoomView(ChatController controller, String name) throws HeadlessException {
        super();
        this.controller = controller;
        this.setTitle(WINDOWS_TITLE + " (" + name + ")");
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

        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));

        this.setVisible(true);



    }

    public void addNewMessage(String username, String message) {
        chatBox.addMessage(username, message);
    }

    public void setParticipant(String[] participants) {
        participantsArea.setParticipants(participants);
    }

    public void resetMessageText() {
        messageArea.reset();
    }

    public String getJTextFieldText() {
        return messageArea.getJTextFieldText();
    }
}
