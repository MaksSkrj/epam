package ua.nure.skrypnyk.practice1;

public class Part4{
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~ part4 ~~~~~~~~~~~~~~" );

        int x;
        int y;

        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);


        while (x != 0 && y != 0){
            if(x > y){
                x %= y;
            }
            else y %= x;
        }

        System.out.println("NOD = " + (x + y));


         }
    }

