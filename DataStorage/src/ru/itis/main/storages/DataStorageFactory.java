package ru.itis.main.storages;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataStorageFactory {

    public static UsersDataStorage getUsersDataStorage() {
        // TODO: метод, возвращающий созданный DataStorage, которому проставлен
        //файл из app.properties
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("resources\\app.properties"));
            String fileName = properties.getProperty("users.file");
            return new UsersDataStorage(fileName);
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    //TODO -метод возвращающий DAO с  Auto
    public static AutoDataStorage getAutoDataStorage() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("resources\\app.properties"));
            String fileName = properties.getProperty("autos.file");
            return new AutoDataStorage(fileName);
        } catch (IOException e) {
            System.err.println("IO Exception ");
        }
        return null;
    }

}
