package ua.nure.skrypnyk.practice4;

import java.io.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable {

    private static final String READING_SENTENCES = "([^.!?]+[.!?])";

    Pattern pattern = Pattern.compile(READING_SENTENCES, Pattern.UNICODE_CHARACTER_CLASS);
    Matcher matcher = pattern.matcher(getInput("practice4part4.txt"));

    public static void main(String[] args) throws IOException {
        Part4 part4 = new Part4();
        myIterator iterator = part4.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    private String getInput(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(filename)), "UTF-8"));
        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine();
            stringBuilder.append(string + " ");
        }
        bufferedReader.close();

        return stringBuilder.toString();
    }

    @Override
    public myIterator iterator() {
        try {
            return new myIterator();
        } catch (IOException e) {
        }
        return null;
    }

    public Part4() throws IOException {
    }

    class myIterator implements Iterator {
        boolean flag = false;

        myIterator() throws IOException {
        }

        @Override
        public boolean hasNext() {
            flag = true;
            return matcher.find();
        }

        @Override
        public Object next() {
            if (flag) {
                flag = false;
                return matcher.group();
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}