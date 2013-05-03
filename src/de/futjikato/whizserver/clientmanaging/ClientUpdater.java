package de.futjikato.whizserver.clientmanaging;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author moritzspindelhirn
 * @todo Documentation
 * @category de.futjikato.whizserver.clientmanaging
 */
public class ClientUpdater implements Runnable {

    protected static ExecutorService exeService = Executors.newFixedThreadPool(10);

    public static void processClientMessage(ClientMessage clientMessage) {
        exeService.submit(new ClientUpdater(clientMessage));
    }

    private Client client;

    private String message;

    public ClientUpdater(ClientMessage clientMessage) {
        client = clientMessage.getClient();
        message = clientMessage.getMessage();
    }

    @Override
    public void run() {
        try {
            client.getWriter().write(message);
            client.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
