package ChatRoom.client;

import ChatRoom.client.controller.LoginController;
import ChatRoom.client.model.ServerConfig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8749;

        ServerConfig serverConfig = new ServerConfig(host, port);

        new LoginController(serverConfig);

    }
}
