package ru.itis.main.generators;

import java.io.*;


public class SimpleIdGenerator implements IdGenerator {
    // имя файла, в котором лежит последний
    // сгенерированный id
    private String idFileName;

    // поле, в котором содержится последний сгенерированный id
    private int lastGeneratedId;


    public SimpleIdGenerator(String idFileName) {
        this.idFileName = idFileName;
        try {
            BufferedReader reader
                    = new BufferedReader(
                    new FileReader(idFileName));
            String id = reader.readLine();
            lastGeneratedId = Integer.parseInt(id);
            reader.close();
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


    @Override
    public int generateId() {
        //TODO: У нас возникает проблема генерации для UserId и AutoId. Подумать над реализацией!
        int newId = lastGeneratedId + 1;
        lastGeneratedId = newId;
        try {
            Writer writer = new FileWriter(idFileName);
            writer.write(newId+"");
            writer.close();
            return newId;
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return -1;
    }
}