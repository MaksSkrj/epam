package ua.nure.skrypnyk.practice1;

public class Part5 {
    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~ part5 ~~~~~~~~~~~~~~");

        String s = args[0];
        int x = 0;

        for (int i = 0; i < s.length(); i++) {

            x += Character.digit(Integer.parseInt(String.valueOf(Integer.valueOf(s.charAt(i)))),10);



        }

        System.out.println(x);
    }
    }

