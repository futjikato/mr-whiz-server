package de.futjikato.whizserver.adminpanel;

import de.futjikato.whizserver.adminpanel.commands.Help;
import de.futjikato.whizserver.clientmanaging.Server;
import de.futjikato.whizserver.clientmanaging.ServerManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public enum Command {
    HELP("help") {
        @Override
        public void execute(BufferedReader bufferReader) {
            Help.openOrPrint();
        }
    },

    START("run") {
        @Override
        public void execute(BufferedReader bufferReader) {
            int port = Integer.valueOf(promt(bufferReader, "Enter port for new server :", new Validator() {
                @Override
                public String filter(String input) {
                    return input.trim();
                }

                @Override
                public boolean validate(String input) {
                    // validate for
                    return Integer.valueOf(input).toString().equals(input);
                }
            }));
            ServerManager.startServer(port);
            System.out.println("Server is waiting for connections.");
        }
    },

    LIST("list") {
        @Override
        public void execute(BufferedReader bufferReader) {
            for(Server server : ServerManager.getServerList()) {
                System.out.println(server);
            }
        }
    },

    EXIT("exit") {
        @Override
        public void execute(BufferedReader bufferReader) {
            Thread.currentThread().interrupt();
        }
    };

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public abstract void execute(BufferedReader bufferReader);

    public static Command getByCommand(String command) {
        for(Command com : values()) {
            if(com.getCommand().equals(command))
                return com;
        }

        return null;
    }

    protected String promt(BufferedReader reader, String question, Validator validator) {
        String userInput = "";
        do {
            try {
                System.out.println(question);
                userInput = reader.readLine();
                userInput = validator.filter(userInput);
            } catch (IOException e) {
                // can handle exception ?
                e.printStackTrace();
            }
        } while(!validator.validate(userInput));

        return userInput;
    }

}
