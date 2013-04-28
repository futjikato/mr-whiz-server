package de.futjikato.whizserver;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: Moritz
 * Date: 28.04.13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    public static Config createFromFile(File configfile) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(configfile));
        Gson gson = new Gson();
        return gson.fromJson(bufferedReader, Config.class);
    }

}
