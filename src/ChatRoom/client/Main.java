package ChatRoom.client;

import ChatRoom.client.controller.LoginController;
import ChatRoom.client.model.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8749;

        boolean defaultServer = true;

        if (!defaultServer) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter server's host: ");
            host = sc.nextLine();
            System.out.print("Enter server's port: ");
            port = sc.nextInt();
        }

        Server server = new Server(host, port);

        new LoginController(server);

    }
}
