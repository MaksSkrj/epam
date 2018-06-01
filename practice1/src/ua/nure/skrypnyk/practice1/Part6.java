package ua.nure.skrypnyk.practice1;

import java.util.ArrayList;

public class Part6 {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~ part6 ~~~~~~~~~~~~~~");

        int arrLength = Integer.parseInt(args[0]);

        int[] arr = new int[arrLength];

        int i = 0;



            for (int j = 2; j < 1000; j++) {

                if (Part6.isSimple(j)){
                    arr[i] = j;
                    i++;
                }
                if (i == arr.length) break;
            }

        System.out.println(Part6.arrToString(arr));
    }




    public static boolean isSimple(int x) {
        boolean isComposite = false;

        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                isComposite = true;
                break;
            }
        }
        if (isComposite) {
            return false;
        } else {
            return true;
        }

    }

    public static String arrToString(int[] arr){
        for (int a: arr) {
            System.out.print(a + " ");

        }
        return null;
    }
}
