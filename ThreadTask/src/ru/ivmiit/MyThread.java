package ru.ivmiit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    private int start;
    private int end;

    private int threadNumber;
    private final static Lock lock = new ReentrantLock();

    public MyThread(int start, int end, int threadNumber) {
        super();
        this.start = start;
        this.end = end;
        this.threadNumber = threadNumber;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            lock.lock();
            Main.result = Main.result + Main.array[i];
            lock.unlock();
        }
    }
}
