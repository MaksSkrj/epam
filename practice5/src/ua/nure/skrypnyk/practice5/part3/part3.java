package ua.nure.skrypnyk.practice5.part3;

public class part3 {
    public static void main(String[] args) {
        CounterClass counter = new CounterClass(0,0);
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);

        thread1.run();
        thread2.run();

        System.out.println("~~~~~~~~~~~~~~~~~~Synchronized~~~~~~~~~~~~~~");

        MySynchronizedThread synchronizedThread1 = new MySynchronizedThread(counter);
        MySynchronizedThread synchronizedThread2 = new MySynchronizedThread(counter);

        synchronizedThread1.run();
        synchronizedThread2.run();

    }
}
