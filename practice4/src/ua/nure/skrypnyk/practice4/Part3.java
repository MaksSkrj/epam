package ua.nure.skrypnyk.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static void main(String[] args) {
        String file = Util.getInput("practice4part3.txt");
        findDataType(file);
    }

    public static void findDataType(String file) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose data type. If you want to break write \"stop\"");
        String s = "";
        while (s != "stop") {
            switch (in.nextLine()) {
                case "int":
                    System.out.println(isInteger(file));
                    break;
                case "string":
                    System.out.println(isString(file));
                    break;
                case "char":
                    System.out.println(isChar(file));
                    break;
                case "double":
                    System.out.println(isDouble(file));
                    break;
                case "stop":
                    s = "stop";
                    break;
            }
        }
        in.close();
    }

    public static String isString(String file) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\p{L}{2,}");
        Matcher m = pattern.matcher(file);
        while (m.find()) {
            sb.append(m.group() + " ");
        }
        return sb.toString();
    }

    public static String isChar(String file) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\pL*");
        Matcher m = pattern.matcher(file);
        while (m.find()) {
            if (m.group().length() < 2 && m.group().length() > 0) sb.append(m.group() + " ");
        }
        return sb.toString();
    }

    public static String isInteger(String file) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\s\\d{1,}\\s");
        Matcher m = pattern.matcher(file);
        while (m.find()) {
            sb.append(m.group().substring(1)).append(" ");
        }
        return sb.toString();
    }

    public static String isDouble(String file) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d*[.]\\d*\\w");
        Matcher m = pattern.matcher(file);
        while (m.find()) {
            sb.append(m.group() + " ");
        }
        return sb.toString();
    }


}
