package ChatRoom.server;

public class Main {
    public static void main(String[] args) {
        new Thread(new Chat()).start();

    }
}
