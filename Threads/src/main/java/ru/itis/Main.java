package ru.itis;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread());
        Thread thread = new MyThread();
        thread.start();
        thread.sleep(100);
        //thread.join();

        Thread.sleep(100);
        for (int i = 1; i < 50; i++) {
            System.out.println("MAIN" + "B" + i);
        }
    }
}
