package ru.itis.main.storages;

import org.junit.Before;
import org.junit.Test;
import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class UsersDataStorageTest {
    @org.junit.Test
    public void find() throws Exception {
    }

    private UsersDataStorage usersDataStorage;

    @Before // Before - говорит JUnit-у о том, что этот метод
    // нужно вызывать перед каждым тестом
    public void setUp() throws Exception {
        this.usersDataStorage = new UsersDataStorage("test\\users.txt",
                new IdGenerator("test\\id.txt"));
    }

    @Test // Test - говорит JUnit-у, что данный метод является методом-тестом
    public void testFind() throws Exception {
        User expected = new User(3, "ayazTheBest", "qwerty008", "Ayaz", 25);
        User actual = usersDataStorage.find(3);
        assertEquals(expected, actual);
    }
    @Test(expected = UserNotFoundException.class)
    public void testFindOnIncorrectData()  throws Exception {
        usersDataStorage.find(10);
    }

    @Test
    public void TestSave() throws Exception {
        User expected = new User("NewName","newname","Name",50);
        int id = usersDataStorage.save(expected);
        expected.setId(id);
        User actual = usersDataStorage.find(id);
        assertEquals(expected,actual);

    }

    @Test
    public void TestFindAll() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("test\\users.txt"));
        List<User> expected = new ArrayList<>();
        String currentUserData = reader.readLine();;
        while((currentUserData)!= null){
            String[] currentUserDataAsArray = currentUserData.split(" ");
            User user = new User(currentUserDataAsArray[1],
                    currentUserDataAsArray[2],
                    currentUserDataAsArray[3],
                    Integer.parseInt(currentUserDataAsArray[4]));
            user.setId(Integer.parseInt(currentUserDataAsArray[4]));
            expected.add(user);
        }

        List<User> actual = usersDataStorage.findAll();
        assertEquals(expected,actual);
    }

    @Test
    public void TestUpdate() throws Exception {
        User expected = new User("NewLogin", "newlogin", "Login", 80);
        expected.setId(2);
        usersDataStorage.update(expected);
        User actual = usersDataStorage.find(2);
        assertEquals(expected,actual);
    }

    @Test
    public void TestDelete() throws Exception{

    }
}