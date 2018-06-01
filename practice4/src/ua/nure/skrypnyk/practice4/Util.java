package ua.nure.skrypnyk.practice4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Util {

    public static String getInput(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            Path filepath = Paths.get(filename);
            Scanner scanner = new Scanner(filepath, "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return sb.toString();
    }
}
