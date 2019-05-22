package ChatRoom.view;

import javax.swing.*;
import java.util.ArrayList;

public class ParticipantsArea extends JList<String> {
    private ArrayList<String> participants = new ArrayList<>();

    public ParticipantsArea() {
        super();
        this.setListData(participants.toArray(new String[participants.size()]));
        this.setVisible(true);
    }

    public void addParticipant(String username) {
        participants.add(username);
        this.setListData(participants.toArray(new String[participants.size()]));
    }

    public void removeParticipant(String username) {
        participants.remove(username);
        this.setListData(participants.toArray(new String[participants.size()]));
    }
}
