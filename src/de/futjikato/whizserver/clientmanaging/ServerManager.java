package de.futjikato.whizserver.clientmanaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public class ServerManager {

    private static List<Server> serverList = new ArrayList<Server>();

    private ServerManager() {

    }

    public static Server startServer(int listen){
        Server server = new Server(listen);
        serverList.add(server);

        return server;
    }

    public static List<Server> getServerList() {
        return serverList;
    }
}
