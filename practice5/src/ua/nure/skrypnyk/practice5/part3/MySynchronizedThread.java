package ua.nure.skrypnyk.practice5.part3;

public class MySynchronizedThread extends Thread{
    CounterClass counter;

    MySynchronizedThread(CounterClass counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            try {
                synchronized (counter) {
                    System.out.print(getName() + ": ");
                    System.out.println(counter.counter1 == counter.counter2);
                    counter.counter1++;
                    sleep(10);
                    counter.counter2++;
                    i++;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
