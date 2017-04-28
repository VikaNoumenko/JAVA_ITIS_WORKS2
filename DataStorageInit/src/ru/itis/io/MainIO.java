package ru.itis.io;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class MainIO {
    public static void main(String[] args) throws Exception {
        // Четыре главных класса java.io

        // оба класса - обеспечивают работу
        // с потоками
        // поток - последовательность байтов
        InputStream inputStream;
        OutputStream outputStream;

        // Три основных потока при запуске программы
        System.out.println("Hello");
        System.err.println("Bye");

        // описал массив для считанных значений
        int bytes[] = new int[15];
        // количество считанных значений
        int count = 0;
        // считываем первый байт
        int byteFromInStream = System.in.read();
        // пока весь массив не заполнился
        while (count < 15) {
            // добавляем в массив новый байт
            bytes[count] = byteFromInStream;
            // считываем новый
            byteFromInStream = System.in.read();
            // увеличиваем количество
            count++;
        }

        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char)bytes[i]);
        }

        byte bytesFromConsole[] = new byte[15];
        int countOfBytes = System.in.read(bytesFromConsole);

        for (int i = 0; i < countOfBytes; i++) {
            System.out.print((char)bytesFromConsole[i]);
        }

        Reader reader;
        Writer writer;


    }
}
