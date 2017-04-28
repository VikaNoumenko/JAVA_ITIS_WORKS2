package ru.itis.main;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.User;
import ru.itis.main.storages.DataStorageFactory;
import ru.itis.main.storages.UsersDataStorage;
import ru.itis.main.storages.AutoDataStorage;
import ru.itis.main.models.Auto;

public class Main {

    public static void main(String[] args) {

//        IdGenerator idGenerator = new IdGenerator("id.txt");
//        UsersDataStorage usersDataStorage = new UsersDataStorage("users.txt", idGenerator);
//        User ayaz = new User("ayazTheBest",
//                "qwerty008", "Ayaz", 25);
//        int id = usersDataStorage.save(ayaz);
//        System.out.println(id);
//        System.out.println(usersDataStorage.find(6));
//        System.out.println(usersDataStorage.findAll());
//        usersDataStorage.delete(2);
//
//        User forUpdate = new User("maksim", "qwerty10", "Maksim", 99);
//        forUpdate.setId(12);
//        usersDataStorage.update(forUpdate);
//
//// For Autos:
//
//
//        IdGenerator idAutoGenerator = new IdGenerator("AutoID.txt");
//        AutoDataStorage autoDataStorage = new AutoDataStorage("autos.txt", idGenerator);
//        Auto auto1 = new Auto("Auto1", "Black", 100);
//        int autoId = autoDataStorage.save(auto1);
//        System.out.println(id);
//        System.out.println(autoDataStorage.find(3));
//        System.out.println(autoDataStorage.findAll());
//        autoDataStorage.delete(2);
//        Auto forUpdating = new Auto("Auto2","Blue",200);
//        forUpdating.setId(2);
//        autoDataStorage.update(forUpdating);

//        UsersDataStorage usersDataStorage = DataStorageFactory.getUsersDataStorage();
//        AutoDataStorage autoDataStorage = DataStorageFactory.getAutoDataStorage();

        DataStorageFactory factory = new DataStorageFactory();

        //UsersDataStorage usersDataStorage = factory.getUsersDataStorage(UsersDataStorage.class);
       // AutoDataStorage autoDataStorage = factory.getAutoDataStorage(AutoDataStorage.class);


    }
    }

