package ua.nure.skrypnyk.practice3.part1;


import java.util.Random;
import java.util.regex.*;

import ua.nure.skrypnyk.practice3.Util;

public class Part1 {
    public static void main(String[] args) {

        String input = Util.getInput("practice3part1.txt");
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println(convert1(input));
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println(convert2(input));
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println(convert3(input));
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println(convert4(input));


    }

    public static String convert1(String input) {
        String pattern = "\\n(.*);(.*);(.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        StringBuilder result = new StringBuilder();
        while (m.find()) {
            result.append(m.group(1))
                    .append(" ==> ")
                    .append(m.group(3))
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    public static String convert2(String input) {
        String pattern = "\\n(.*);(.*)\\s(.*);(.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        StringBuilder result = new StringBuilder();
        while (m.find()) {
            result.append(m.group(3))
                    .append(" ")
                    .append(m.group(2))
                    .append(" (email:  ")
                    .append(m.group(4))
                    .append(")")
                    .append(System.lineSeparator());
        }
        return result.toString();

    }

    public static String convert3(String input) {
        String pattern = "\\n(.*);(.*)\\s(.*);(.*)@(.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m1 = p.matcher(input);
        Matcher m2 = p.matcher(input);
        StringBuilder result = new StringBuilder();
        while (m1.find()) {
            if (result.indexOf(m1.group(5)) == -1) {
                result.append(m1.group(5)).append(" ==> ");
                while (m2.find()) {
                    if (m2.group(5).equals(m1.group(5))) {
                        result.append(m2.group(1)).append(", ");
                    }
                }
                result.replace(result.length() - 2, result.length(), System.lineSeparator());
                m2.reset();
            }
        }
        return result.toString();
    }

    public static String convert4(String input) {
        String pattern = "\\n(.*);(.*)\\s(.*);(.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        StringBuilder result = new StringBuilder();
        result.append("Login;Name;Email;Password").append(System.lineSeparator());
        while (m.find()) {
            Random random = new Random();
            result.append(m.group(1) + ";").append(m.group(2) + " ").append(m.group(3) + ";")
                    .append(m.group(4) + ";")
                    .append(random.nextInt(9000) + 1000)
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

}