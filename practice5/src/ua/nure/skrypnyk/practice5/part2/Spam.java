package ua.nure.skrypnyk.practice5.part2;

import java.util.ArrayList;
import java.util.Scanner;

public class Spam {
    private int[] times;
    private String[] messages;
    private ArrayList<SpamThread> threads = new ArrayList<>();

    public Spam(int[] times, String[] messages) {
        this.times = times;
        this.messages = messages;
        for (int i = 0; i < messages.length; i++) {
            SpamThread spamThread = new SpamThread(times[i], messages[i]);
            threads.add(spamThread);
        }
    }

    public void start() {
        for (SpamThread thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        for (SpamThread thread : threads) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) {
        Spam spam = new Spam(new int[]{333, 555}, new String[]{"AAAA", "bbb"});
        spam.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        spam.stop();
        sc.close();
    }
}
