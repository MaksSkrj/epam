package ua.nure.skrypnyk.practice5.part1;

public class Part1 {
    public static void main(String[] args) {
        ThreadUtils thread = new ThreadUtils();
        Thread runnable = new Thread(new RunnableUtils());
        thread.start();
        runnable.start();
    }
}

class ThreadUtils extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 7) {
            try {
                System.out.println(getName());
                sleep(500);
                i++;
            } catch (InterruptedException ex) {
            }
        }
    }
}

class RunnableUtils implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (i < 7) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().sleep(500);
                i++;
            } catch (InterruptedException ex) {
            }
        }
    }
}