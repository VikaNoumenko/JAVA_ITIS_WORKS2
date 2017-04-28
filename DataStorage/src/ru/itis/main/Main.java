package ru.itis.main;

import ru.itis.main.dao.AutoDaoFileBasedImpl;
import ru.itis.main.models.Auto;

public class Main {

    public static void main(String[] args) {

        Auto auto = new Auto(1,"Model","Black", 100, true);
        AutoDaoFileBasedImpl autoDaoFileBasedImpl = new AutoDaoFileBasedImpl("autos.txt");
        System.out.println(autoDaoFileBasedImpl.save(auto));
    }
}
