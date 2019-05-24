package ChatRoom.client.view;

import javax.swing.*;

public class ParticipantsArea extends JList<String> {

    public ParticipantsArea() {
        super();
//        this.setListData(participants.toArray(new String[participants.size()]));
        this.setVisible(true);
    }

    public void setParticipants(String[] participants) {
        this.setListData(participants);
    }
}
