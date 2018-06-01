package ua.nure.skrypnyk.practice4;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        createFile(10);
        String file = Util.getInput("practice4part2.txt");
        sortFile(file);
        String file_new = Util.getInput("practice4part2_new.txt");
        System.out.println("Input ==> " + file);
        System.out.println("Output ==> " + file_new);

    }

    static void createFile(int intCount) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("practice4part2.txt"));
        Random rnd = new Random();
        int[] numbs = new int[intCount];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = rnd.nextInt(50);
            printWriter.write(numbs[i] + " ");
        }
        printWriter.close();
    }

    static void sortFile(String file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("practice4part2_new.txt"));
        String[] stringNumbers = file.split(" ");
        int[] intNumbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(stringNumbers[i]);
        }

        for (int i = intNumbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (intNumbers[j] > intNumbers[j + 1]) {
                    int tmp = intNumbers[j];
                    intNumbers[j] = intNumbers[j + 1];
                    intNumbers[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < intNumbers.length; i++) {
            printWriter.write(intNumbers[i] + " ");
        }
        printWriter.close();
    }


}
