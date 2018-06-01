package ua.nure.skrypnyk.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
    public static void main(String[] args){
        readFromConsole();
    }

    public static final String RESOURCE_BUNDLE_NAME = "resources";

    public static void readFromConsole() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input == null || input.equals("stop"))
                break;
            System.out.println(getValue(input));
        }
        sc.close();
    }

    public static String getValue(String input) {
        Pattern pattern = Pattern.compile("(?U)(\\w+)\\s(\\w+)");
        Matcher matcher = pattern.matcher(input);

        String value = null;
        if (matcher.find()) {
            String key = matcher.group(1);
            String locale = matcher.group(2);
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale(locale));
            value = resourceBundle.getString(key);
        }
        return value;
    }
}
