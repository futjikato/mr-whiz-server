package de.futjikato.whizserver.clientmanaging;

/**
 * @author moritzspindelhirn
 * @todo Documentation
 * @category de.futjikato.whizserver.clientmanaging
 */
public class ClientMessage {

    private final String message;
    private final Client client;

    public ClientMessage(Client client, String message) {
        this.client = client;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Client getClient() {
        return client;
    }

}
