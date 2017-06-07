package ru.ivmiit;

import sun.awt.windows.ThemeReader;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int RESULT = 0;

    public static void main(String[] args) throws InterruptedException {
	    // объявили массив чисел
    	int array[];
    	// объявили класс для считывания
	    Scanner scanner = new Scanner(System.in);
		// считали количество чисел
	    int n = scanner.nextInt();
	    // выделили память для массива
	    array = new int[n];
		// объявили генератор случайных чисел
        Random random = new Random();
        // заполнили массив случайными числами
	    for (int i = 0; i < n; i++) {
	        array[i] = random.nextInt(100);
        }
		// вывели его на экран и посчитали сумму чисел без потоков
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // System.out.print(array[i] + " ");
            sum += array[i];
        }
		System.out.println();
        // вывели сумму чисел на экран
		System.out.println(sum);

		// считали количество потоков
		int threadsCount = scanner.nextInt();

        long begin = System.nanoTime();
		// создали массив для хранения результатов
		// i-ый поток хранит свою сумму в results[i]
	    int results[] = new int[threadsCount];

	    // создали массив потоков
        MyThread threads[] = new MyThread[threadsCount];

        // задали для каждого потока его границы подсчета
	    for (int i = 0; i < threadsCount; i++) {
	    	int start = i * (n / threadsCount);
	    	int end = start + n / threadsCount;
			threads[i] = new MyThread(start,end,array,results,i);
		}
		int lastThreadIndex = threadsCount - 1;
        // для последнего потока указали границу до конца массива
        threads[lastThreadIndex] = new MyThread(lastThreadIndex * (n / threadsCount), array.length, array, results, lastThreadIndex);

        // запустили все потоки, усыпив главный поток
		for (int i = 0; i < threads.length; i++) {
	    	threads[i].start();
		}

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
		// вывели список результатов
        int result = 0;
//		for (int i = 0; i < results.length; i++) {
//			result = results[i] + result;
//		}
        System.out.println(((System.nanoTime() - begin)/1000000000.0));
        System.out.println(RESULT);
    }
}
