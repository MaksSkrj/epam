package ua.nure.skrypnyk.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        String file = Util.getInput("practice4part1.txt");
        System.out.println("input: " + file);
        System.out.println("output: " + isMoreThenThree(file));
    }


    public static String isMoreThenThree(String file) {
        Pattern pattern = Pattern.compile("\\p{L}{4,}");
        Matcher m = pattern.matcher(file);
        while (m.find()) {
            file = file.replace(m.group(), m.group().toUpperCase());
        }

        return file;
    }

}
