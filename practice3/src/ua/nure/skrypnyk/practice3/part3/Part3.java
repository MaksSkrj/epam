package ua.nure.skrypnyk.practice3.part3;


import ua.nure.skrypnyk.practice3.Util;

public class Part3 {
    public static void main(String[] args) {
        String input = Util.getInput("practice3part3.txt");
        System.out.println(partThreeUtils(input));
    }

    public static String partThreeUtils(String input) {
        StringBuilder result = new StringBuilder();
        String[] str = input.split(" ");
        for (String s : str) {
            result.append(s.substring(0, 1).toUpperCase() + s.substring(1))
                    .append(" ");
        }
        String pattern = "(\\b\\w)(\\B\\w+)";

        return result.toString();
    }
}
