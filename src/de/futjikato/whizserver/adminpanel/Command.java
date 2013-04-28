package de.futjikato.whizserver.adminpanel;

import de.futjikato.whizserver.adminpanel.commands.Help;

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
        public void execute() {
            Help.openOrPrint();
        }
    },

    START("run") {
        @Override
        public void execute() {

        }
    },

    EXIT("exit") {
        @Override
        public void execute() {
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

    public abstract void execute();

    public static Command getByCommand(String command) {
        for(Command com : values()) {
            if(com.getCommand().equals(command))
                return com;
        }

        return null;
    }

}
