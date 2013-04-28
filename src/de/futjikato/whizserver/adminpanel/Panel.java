package de.futjikato.whizserver.adminpanel;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public final class Panel extends Thread {

    private boolean closeRequested = false;

    public void run() {
        // await user input
        InputStreamReader inputReader = new InputStreamReader(System.in) ;
        BufferedReader bufferReader = new BufferedReader(inputReader);

        System.out.println("Enter a command or `help` if you don´t know what to do.");
        do {
            try {
                String command = bufferReader.readLine();
                Command cmd = Command.getByCommand(command);

                if(cmd == null) {
                    System.out.format("Unknown command %s \n", command);
                } else {
                    cmd.execute();
                }
            } catch (IOException e) {
                interrupt();
            }
        } while(!isInterrupted());
    }

    public void printWelcomeMsg() {

    }
}
