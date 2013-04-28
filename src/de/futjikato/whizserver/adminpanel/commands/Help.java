package de.futjikato.whizserver.adminpanel.commands;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
public class Help {
    public static void openOrPrint() {
        String url = "http://google.de";
        if(!openBrowser(url))
            printHelp();
    }

    private static void printHelp() {
        // @todo read help from file and print to stdout
        System.out.println("@TODO print help from file");
    }

    public static boolean openBrowser(String url) {
        try {
            if(Desktop.isDesktopSupported() ) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
                    java.net.URI uri = new java.net.URI(url);
                    desktop.browse(uri);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch(URISyntaxException e) {
            return false;
        } catch(IOException e) {
            return false;
        }
    }
}
