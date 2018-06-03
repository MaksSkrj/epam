package ua.nure.skrypnyk.practice5.part5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 {
    public static void main(String[] args) {
        try{
            RandomAccessFile file = new RandomAccessFile("practice5part5.txt", "rw");
            for (int i = 0; i <= 9; i++) {
                new MyThread(i, file).start();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

}
