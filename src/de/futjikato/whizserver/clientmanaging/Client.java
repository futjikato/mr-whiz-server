package de.futjikato.whizserver.clientmanaging;

import java.io.*;
import java.net.Socket;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class Client extends Thread {

    private Socket socket;

    private Server server;

    private OutputStreamWriter writer;

    private BufferedReader reader;

    public Client(Server server, Socket clientSocket) throws IOException {
        this.server = server;
        socket = clientSocket;

        writer = new OutputStreamWriter(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                String line = reader.readLine();

                if(line == null) {
                    break;
                }

                server.broadcast(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected OutputStreamWriter getWriter() {
        return writer;
    }
}
