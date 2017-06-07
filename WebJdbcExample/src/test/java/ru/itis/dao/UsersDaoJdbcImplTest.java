package ru.itis.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.config.app.TestAppConfig;
import ru.itis.dao.impl.UsersDaoJdbcImpl;
import ru.itis.models.User;

import static org.junit.Assert.*;

/**
 * 16.05.2017
 * UsersDaoJdbcImplTest
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
public class UsersDaoJdbcImplTest {

    @Autowired
    private UsersDaoJdbcImpl usersDao;

    private final int USER_6_ID = 6;
    private final User USER_6 = new User.Builder()
            .id(USER_6_ID)
            .login("Denis")
            .password("qwerty010")
            .name("Денис")
            .age(22)
            .build();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        User expected = USER_6;
        User actual = usersDao.find(USER_6_ID);

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDelete() {
        usersDao.delete(USER_6_ID);
        usersDao.find(USER_6_ID);
    }
}