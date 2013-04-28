package de.futjikato.whizserver.clientmanaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        while(!isInterrupted()) {
            try {
                Socket client = socket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                interrupt();
            }
        }
    }
}
