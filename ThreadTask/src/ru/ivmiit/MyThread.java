package ru.ivmiit;


import static ru.ivmiit.Main.RESULT;

public class MyThread extends Thread {
    private int start;
    private int end;
    public static final Object lock = new Object();
    private int array[];

    private int resultsArray[];

    private int threadNumber;

    public MyThread(int start, int end, int array[], int resultsArray[], int threadNumber) {
        super();
        this.start = start;
        this.end = end;
        this.array = array;
        this.resultsArray = resultsArray;
        this.threadNumber = threadNumber;
    }

    public void run() {
        //int result = 0;
        synchronized (lock) {
            for (int i = start; i < end; i++) {
                //System.out.println("Считает поток: " + threadNumber + ", значения [" + start + ", " + end + "]");
                //result = result + array[i];
                RESULT = RESULT + array[i];
            }
        }
        //System.out.println("Посчитал поток: " + threadNumber + ", результат: " + result);
        //resultsArray[threadNumber] = result;
    }
}
