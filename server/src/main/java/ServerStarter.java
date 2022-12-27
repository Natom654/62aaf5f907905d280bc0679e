import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ServerStarter {
    public static final int PORT = 8888;
    private final ServerSocket serverSocket;
    private final Set<ClientHandler> handlers = new HashSet<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final Logger log = LogManager.getLogger((ServerStarter.class));

    @SneakyThrows
    public ServerStarter() {
        this.serverSocket = new ServerSocket(PORT);

        log.info("Server is about to start on port: {}", PORT);

        while (true) {
            var accept = serverSocket.accept();
            var name = "client-" + (handlers.size() + 1);
            executorService.submit(() -> {
                ClientHandler handler = null;
                try {
                    handler = new ClientHandler(accept, name, Instant.now());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                broadcast(String.format("[SERVER] % is connected successfull", name));
                handlers.add(handler);
            });
        }
    }

    public void broadcast(String message) {
        handlers.forEach(ch -> ch.sendMessage(message));
    }
}
