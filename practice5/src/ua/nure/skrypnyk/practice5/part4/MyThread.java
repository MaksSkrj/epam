package ua.nure.skrypnyk.practice5.part4;

public class MyThread extends Thread {
    int[] arr;
    int max = 0;

    public MyThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    sleep(1);
                }
            }
        } catch (Exception ex) {

        }
    }

    public int getMax() {
        return max;
    }
}
