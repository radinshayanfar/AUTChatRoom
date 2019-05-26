package ChatRoom.client.model;

public class ServerConfig {
    private String host;
    private int port;

    public ServerConfig(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
