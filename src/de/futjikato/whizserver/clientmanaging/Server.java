package de.futjikato.whizserver.clientmanaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class Server extends Thread {

    protected ServerSocket socket;

    protected Game currentGame;

    protected Collection<Client> clients = new ArrayList<Client>();

    public Server(int port) {
        try {
            currentGame = new Game();

            // start tcp server
            socket = new ServerSocket(port);

            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                Socket clientSocket = socket.accept();
                Client client = new Client(this, clientSocket);
                addClient(client);

                ClientUpdater.processClientMessage(new ClientMessage(client, "Welcome to the mr-whiz server!"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WhizServerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Server listening on port %d", socket.getLocalPort());
    }

    public void addClient(Client client) throws WhizServerException {
        if(clients.contains(client))
            throw new WhizServerException("Client already on server.");

        clients.add(client);
    }

    public void broadcast(String message) {
        for(Client client : clients) {
            ClientUpdater.processClientMessage(new ClientMessage(client, message));
        }
    }
}
