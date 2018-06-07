package ua.nure.skrypnyk.practice6.part6;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {

        try {
            System.out.println(doTask(getOrderedArgs(args)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String[] getOrderedArgs(String[] args){
        String[] orderedArgs = new String[2];//1st argument --> fileName; 2nd --> task;
        switch (args[0]) {
            case "-i":
            case "--input": {
                orderedArgs[0] = args[1];
                orderedArgs[1] = args[3];
                break;
            }
            case "-t":
            case "--task": {
                orderedArgs[0] = args[3];
                orderedArgs[1] = args[1];
                break;
            }
        }
        return orderedArgs;
    }

    private static String doTask(String[] args) throws IOException {
        String input = getContentOfFile(args[0]);
        switch (args[1]) {
            case "length":
                return getLength(input);
            case "frequency":
                return getFrequency(input);
            case "duplicates":
                return getDuplicates(input);
        }
        return null;
    }

    private static String getContentOfFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            sb.append(bufferedReader.readLine());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static Map<String, Integer> splitFile(String file) {
        Map<String, Integer> wordsMap = new HashMap<>();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(file);
        int value;
        while (matcher.find()) {
            String s = matcher.group();
            if (wordsMap.containsKey(s)) {
                value = wordsMap.get(s);
                wordsMap.remove(s);
                wordsMap.put(s, value + 1);
            } else {
                wordsMap.put(s, 1);
            }
        }
        return wordsMap;
    }

    private static String getFrequency(String file) {
        Map<String, Integer> wordsMap = splitFile(file);
        StringBuilder result = new StringBuilder();

        List<Map.Entry<String, Integer>> words = new LinkedList<>(wordsMap.entrySet());
        Collections.sort(words, (o1, o2) -> o2.getValue() - o1.getValue());
        List<Map.Entry<String, Integer>> mostFrequentWords = words.subList(0, 3);
        Collections.sort(mostFrequentWords, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        for (Map.Entry<String, Integer> entry : mostFrequentWords) {
            result.append(entry.getKey()).append(" ==> ").append(entry.getValue()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    private static String getLength(String file) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(file);
        List<String> words = new LinkedList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        Collections.sort(words, (o1, o2) -> o2.length() - o1.length());

        StringBuilder result = new StringBuilder();
        Iterator<String> it = words.iterator();
        int count = 0;
        while (count < 3) {
            String word = it.next();
            result.append(word).append(" ==> ").append(word.length()).append(System.lineSeparator());
            count++;
        }
        return result.toString().trim();

    }

    private static String getDuplicates(String input) {
        Map<String, Integer> wordsCounts = splitFile(input);

        StringBuilder result = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordsCounts.entrySet()) {
            if (count == 3)
                break;
            if (entry.getValue() >= 2) {
                result.append(new StringBuilder((entry.getKey())).reverse().toString().toUpperCase()).append(System.lineSeparator());
                count++;
            }
        }
        return result.toString().trim();
    }
}
