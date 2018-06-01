package ua.nure.skrypnyk.practice3.part2;

import ua.nure.skrypnyk.practice3.Util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part2 {
    public static void main(String[] args) {
        String input = Util.getInput("practice3part2.txt");
        System.out.println(partTwoUtils(input));
    }

    public static String partTwoUtils(String input) {
        StringBuilder minResult = new StringBuilder().append("min: ");
        StringBuilder maxResult = new StringBuilder().append("max: ");
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String pattern = "(\\w*)(\\b)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        while (m.find()) {
            list.add(m.group(1));
        }

        set.addAll(list);
        list.clear();
        list.addAll(set);

        for (int i = 0; i < list.size(); i++) {

        }

        int max = 0;
        int min = 1000;

        for (String s : list) {
            if (s.length() < min && s.length() > 0) min = s.length();
            if (s.length() > max) max = s.length();
        }

        for (String s : list) {
            if (s.length() == min) minResult.append(s + " ");
            if (s.length() == max) maxResult.append(s + " ");
        }

        return minResult.append(System.lineSeparator()).toString() + maxResult.toString();
    }
}