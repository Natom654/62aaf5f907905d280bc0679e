import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.Instant;
import java.util.Scanner;
import java.util.function.Consumer;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class ClientHandler {
    Socket socket;
    String name;
    Instant createdAt;
    DataInputStream in;
    DataOutputStream out;


    private static final Logger log = LogManager.getLogger(ClientHandler.class);
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;


    @SneakyThrows
    public ClientHandler(Socket socket, String name, Instant createdAt) throws IOException {
        this.socket = socket;
        this.name = name;
        this.createdAt = createdAt;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        log.info("Client is about to start ...");
        socket = new Socket(SERVER_HOST, SERVER_PORT);
        log.info(
                "Client is up and running on: {}:{}",
                socket.getInetAddress().getHostName(),
                socket.getLocalPort()
        );

        log.info("The client successfully connected: {}", socket.getRemoteSocketAddress());

        new Thread(getListener()).start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            var outboundMessage = scanner.nextLine();
            out.writeUTF(outboundMessage);
            if (outboundMessage.equals("-exit")) {
                log.info("Client disconnected...");
                break;
            }
        }
    }

    private Runnable getListener() {
        return () -> {
            try {
                while (true) {
                    var inboundMessage = in.readUTF();
                    if (inboundMessage.toLowerCase().contains("bye")) {
                        break;
                    }
                    System.out.println("Server response: " + inboundMessage);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @SneakyThrows
    public void sendMessage(String message) {
        out.writeUTF(message);
    }
}

