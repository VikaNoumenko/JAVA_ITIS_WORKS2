package ru.itis.test;

import org.junit.Before;
import org.junit.Test;
import ru.itis.main.dao.UsersDaoFileBasedImpl;
import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.models.User;

import static org.junit.Assert.*;

/**
 * 18.04.2017
 * UsersDaoFileBasedImplTest
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersDaoFileBasedImplTest {

    // объектная переменная для тестируемого класса
    private UsersDaoFileBasedImpl usersDaoFileBasedImpl;

    @Before // Before - говорит JUnit-у о том, что этот метод
    // нужно вызывать перед каждым тестом
    public void setUp() throws Exception {
        //this.usersDaoFileBasedImpl = new UsersDaoFileBasedImpl("test\\users.txt",
          //      new IdGenerator("test\\id.txt"));
    }

    @Test // Test - говорит JUnit-у, что данный метод является методом-тестом
    public void testFind() throws Exception {
        User expected = new User(3, "ayazTheBest", "qwerty008", "Ayaz", 25);
        User actual = usersDaoFileBasedImpl.find(3);

        assertEquals(expected, actual);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindOnIncorrectData()  throws Exception {
        usersDaoFileBasedImpl.find(10);
    }
}