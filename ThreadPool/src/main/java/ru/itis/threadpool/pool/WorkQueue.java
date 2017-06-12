package ru.itis.threadpool.pool;

import java.util.Deque;
import java.util.LinkedList;

public class WorkQueue {
    // количество потоков
    private final int threadsCount;

    // потоки
    private final PoolWorker[] threads;

    // задачи пула
    private final Deque<Runnable> tasks;

    public WorkQueue(int threadsCount) {
        this.threadsCount = threadsCount;

        tasks = new LinkedList<>();

        threads = new PoolWorker[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void submit(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            // текущая задача, которую хочет взять на исполнение
            // какой-либо PoolWorker
            Runnable task;

            // бесконечный цикл
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                }
                task = tasks.removeFirst();
                task.run();
            }
        }
    }

}
