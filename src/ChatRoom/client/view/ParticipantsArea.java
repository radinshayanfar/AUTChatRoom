package ChatRoom.client.view;

import javax.swing.*;

class ParticipantsArea extends JList<String> {

    ParticipantsArea() {
        super();
        this.setVisible(true);
    }

    void setParticipants(String[] participants) {
        this.setListData(participants);
    }
}
