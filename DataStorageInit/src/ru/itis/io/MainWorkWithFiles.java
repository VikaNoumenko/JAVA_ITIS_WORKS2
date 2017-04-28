package ru.itis.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainWorkWithFiles {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream
                = new FileInputStream("input.txt");

        int byteFromFile = inputStream.read();
        System.out.println((char)byteFromFile);

        byte bytes[] = new byte[15];
        int countOfBytes = inputStream.read(bytes);

        for (int i = 0; i < countOfBytes; i++) {
            System.out.print((char)bytes[i]);
        }

        inputStream.close();

        FileOutputStream outputStream =
                new FileOutputStream("output.txt");

        char b = 'A';
        int byteB = b;

        outputStream.write(byteB);

        byte[] bytes1 = "Hello!".getBytes();
        outputStream.write(bytes1);
        outputStream.close();
    }
}
