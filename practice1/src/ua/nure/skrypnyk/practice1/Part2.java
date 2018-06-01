package ua.nure.skrypnyk.practice1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws IOException {

        System.out.println("~~~~~~~~~~~~~~ part2 ~~~~~~~~~~~~~~" );

        int x;
        int y;

        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);

        int z = x +y;

        System.out.println("sum of your numbers = " + z);

    }
}
