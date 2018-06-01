package ua.nure.skrypnyk.practice5.part2;

public class SpamThread extends Thread{
    private int time;
    private String message;

    public SpamThread(int time, String message) {
        this.time = time;
        this.message = message;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(message);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
