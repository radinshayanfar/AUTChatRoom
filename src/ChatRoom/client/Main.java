package ChatRoom.client;

import ChatRoom.client.controller.LoginController;
import ChatRoom.client.model.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String host = sc.nextLine();
        int port = sc.nextInt();

        Server server = new Server(host, port);

        new LoginController(server);

    }
}
