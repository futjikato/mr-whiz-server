package de.futjikato.whizserver.clientmanaging;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    private String identifier;

    public Client(String ip, int port, String token) {
        identifier = String.format("%s:%d:%s", ip, port, token);
    }

    public String getIdentifier() {
        return identifier;
    }
}
