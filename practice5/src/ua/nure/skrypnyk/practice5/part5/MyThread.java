package ua.nure.skrypnyk.practice5.part5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MyThread extends Thread {
    public static final int NUMBERS_QUANTITY = 20;

    private int number;
    private RandomAccessFile file;
    private long pointer;

    public MyThread(int number, RandomAccessFile file) {
        this.number = number;
        this.file = file;
        if (number != 0)
            pointer = number * (NUMBERS_QUANTITY + 1);
    }

    @Override
    public void  run(){
        try {
            for (int i = 0; i < NUMBERS_QUANTITY; i++) {
                synchronized (file) {
                    file.seek(pointer);
                    file.write('0' + number);
                    pointer = file.getFilePointer();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (file) {
                file.seek(pointer);
                file.write(System.lineSeparator().getBytes());
                pointer = file.getFilePointer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
