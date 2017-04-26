package ru.itis.main.storages;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataStorageFactory {


    private Properties properties;

    public DataStorageFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources\\app.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    private UsersDataStorage getUsersDataStorage() {

        //файл из app.properties
        try {
            String UsersDataStorage = properties.getProperty("UsersDataStorage.class");
            Class<UsersDataStorage> UsersDataStorageClass = (Class<UsersDataStorage>) Class.forName(UsersDataStorage);
            UsersDataStorage instance = UsersDataStorageClass.newInstance();
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }
    public <T> T daoClass(Class<T> daoClass) {
        if (daoClass.getName().equals("ru.itis.UsersDataStorage")) {
            return (T)getUsersDataStorage();
        } else if (daoClass.getName().equals("ru.itis.AutoDataStorage")) {
            return (T)getAutoDataStorage();
        } else {
            throw new IllegalArgumentException("No instance");
        }
    }
   private AutoDataStorage getAutoDataStorage() {
        try {
            String AutoDataStorage = properties.getProperty("AutoDataStorage.class");
            Class<AutoDataStorage> AutoDataStorageClass = (Class<AutoDataStorage>) Class.forName(AutoDataStorage);
            AutoDataStorage instance = AutoDataStorageClass.newInstance();
             return instance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
   }

}
