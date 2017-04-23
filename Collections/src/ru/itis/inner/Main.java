package ru.itis.inner;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Deque<Integer> integerQueue = new LinkedList<>();

        integerQueue.addFirst(10);
        integerQueue.addFirst(11);
        integerQueue.addFirst(12);

        int i = 0;
        while (i < 3){
            System.out.println(integerQueue.poll());
            i++;
        }
    }
}
