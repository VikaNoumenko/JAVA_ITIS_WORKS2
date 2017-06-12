package ru.itis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelAdder {
    public Integer parallelSum() {
        // создали пул из 10 потоков
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // создали список результатов
        long t1 = System.currentTimeMillis();
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 100000; i++) {
            //System.out.println("Prev :" + i + " current: " + (i+1));
            // кладем задачу на выполнение
            Future<Integer> future = executor.submit(new CallableAdder(i, i+1));
            list.add(future);
            i++;
        }
        int sum = 0;
        for (Future<Integer> future : list) {
            try {
                sum = sum + future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken by parallelSum " + (t2-t1));
        //System.out.println("Total Sum is " + sum);
        return sum;
    }

    public Integer sequenceSum() {
        long t1 = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum = sum + i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken by sequenceSum " + (t2-t1));
        //System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        ParallelAdder adder = new ParallelAdder();
        adder.parallelSum();
        adder.sequenceSum();
    }
}
