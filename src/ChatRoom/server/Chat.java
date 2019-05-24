package ChatRoom.server;

import ChatRoom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Chat implements Runnable {

    private ArrayList<Participant> participants = new ArrayList<>();

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8749);
            while (true) {
                Socket socket = serverSocket.accept();

                ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

                String name = (String) inStream.readObject();

                System.out.println(name + " connected!");

                Participant newParticipant = new Participant(outStream, inStream, name, this);
                participants.add(newParticipant);
                setParticipantsToAll();

                new Thread(newParticipant).start();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(Message message) {
        for (Participant p :
                participants) {
            p.sendObject(message);
        }
    }

    public void setParticipantsToAll() {
        String[] parArray = new String[participants.size()];
        for (int i = 0; i < parArray.length; i++) {
            parArray[i] = participants.get(i).getName();
        }
        for (Participant p :
                participants) {
            p.sendObject(parArray);
        }
    }

    public void deleteParticipant(Participant participant) {
        participants.remove(participant);
        setParticipantsToAll();
    }
}
