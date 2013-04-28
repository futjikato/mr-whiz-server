package de.futjikato.whizserver;

import de.futjikato.whizserver.adminpanel.Panel;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static Config config;

    public static void main(String[] args) {
        // @todo handle start options

        // read config file
        try {
            config = Config.createFromFile(new File("config/config.json"));
        } catch (FileNotFoundException e) {
            System.out.println("Error reading config file. Unable to start up ):");
            e.printStackTrace();
            return;
        }

        // start up admin panel
        Panel adminpanmel = new Panel();
        adminpanmel.start();
    }
}
