package ru.itis.main.generators;

import java.io.*;
import java.util.Properties;

/**
 * 18.04.2017
 * SimpleIdGenerator
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SimpleIdGenerator implements IdGenerator {
    // имя файла, в котором лежит последний
    // сгенерированный id
    private String idFileName;

    // поле, в котором содержится последний сгенерированный id
    private int lastGeneratedId;

    public SimpleIdGenerator(String idFileName) {
        this.idFileName = idFileName;
        try {
            BufferedReader bufferedReader
                    = new BufferedReader(
                    new FileReader(idFileName));
            String id = bufferedReader.readLine();
            lastGeneratedId = Integer.parseInt(id);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
    /**
     * Генерирует новый id,всегда уникальный
     * и всегда на один больше, чем последний сгенерированный
     * @return сгенерированный идентификатор
     */
    public int generateId() {
        int newId = lastGeneratedId + 1;
        lastGeneratedId = newId;
        try {
            Writer writer = new FileWriter(idFileName);
            writer.write(newId + "");
            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return newId;
    }
}
