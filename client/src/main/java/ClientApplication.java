import java.io.IOException;
import java.net.Socket;
import java.time.Instant;
import java.util.function.Consumer;

public class ClientApplication {
    public static void main(String[] args) throws IOException {

        new ClientHandler(new Socket("localhost",8888), "client 1", Instant.now());
    }
}
