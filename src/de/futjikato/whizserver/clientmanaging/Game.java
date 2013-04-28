package de.futjikato.whizserver.clientmanaging;

import java.util.HashMap;

/**
 * Abstraction of a running game on a server
 */
public class Game {

    protected HashMap<String, Client> clientmap = new HashMap<String, Client>();

    public void addClient(Client client) {
        clientmap.put(client.getIdentifier(), client);
    }

    public Client getClient(String ident) {
        if(clientmap.containsKey(ident))
            return clientmap.get(ident);

        return null;
    }
}
