package ru.itis.main.context;

import ru.itis.main.dao.jdbc.AutoDao;
import ru.itis.main.dao.jdbc.UsersDao;
import ru.itis.main.generators.IdGenerator;
import ru.itis.main.services.UsersService;
import ru.itis.main.utils.FileDaoQueryTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AppContext {
    private Properties properties;
    private String daoProfile;

    public AppContext() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("resources\\app.properties"));
            daoProfile = properties.getProperty("dao.profile");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T getComponent(Class<AutoDao> componentClass) {
        try {
            if (componentClass.getName().equals("ru.itis.main.services.UsersService")) {
                return (T) getUsersService();
            } else if (componentClass.getName().equals("ru.itis.main.dao.jdbc.AutoDao")) {
                return (T) getAutoDao();
            } else if (componentClass.getName().equals("ru.itis.main.dao.jdbc.UsersDao")) {
                return (T) getUsersDao();
            } else if (componentClass.getName().equals("java.sql.Connection")) {
                return (T) getConnection();
            } else {
                throw new IllegalArgumentException();
            }
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }

    private IdGenerator getIdGenerator() throws ReflectiveOperationException {
        String idGeneratorClassName = properties.getProperty("id.generator.class");
        String idFileName = properties.getProperty("id.file.name");
        Class<IdGenerator> idGeneratorClass = (Class<IdGenerator>) Class.forName(idGeneratorClassName);
        Constructor<IdGenerator> idGeneratorConstructor = idGeneratorClass.getConstructor(String.class);
        IdGenerator idGenerator = idGeneratorConstructor.newInstance(idFileName);
        return idGenerator;
    }

    private FileDaoQueryTemplate getFileDaoQueryTemplate() throws ReflectiveOperationException {
        String fileDaoQueryTemplateClassName = properties.getProperty("file.query.template.class");
        Class<FileDaoQueryTemplate> fileDaoQueryTemplateClass = (Class<FileDaoQueryTemplate>)
                Class.forName(fileDaoQueryTemplateClassName);
        Constructor<FileDaoQueryTemplate> fileDaoQueryTemplateConstructor =
                fileDaoQueryTemplateClass.getConstructor(IdGenerator.class);
        FileDaoQueryTemplate fileDaoQueryTemplate =
                fileDaoQueryTemplateConstructor.newInstance(getIdGenerator());
        return fileDaoQueryTemplate;
    }

    private UsersDao getUsersDao() throws ReflectiveOperationException {
        if (daoProfile.equals("files")) {
            String usersDaoClassName = properties.getProperty("users.dao.class");
            String daoFileName = properties.getProperty("users.file.name");
            Class<UsersDao> usersDaoClass = (Class<UsersDao>) Class.forName(usersDaoClassName);
            Constructor<UsersDao> usersDaoConstructor = usersDaoClass.getConstructor(String.class, FileDaoQueryTemplate.class);
            UsersDao usersDao = usersDaoConstructor.newInstance(daoFileName, getFileDaoQueryTemplate());
            return usersDao;
        } else if (daoProfile.equals("jdbc")){
            String usersDaoClassName = properties.getProperty("users.jdbc.dao.class");
            Class<UsersDao> usersDaoClass = (Class<UsersDao>) Class.forName(usersDaoClassName);
            Constructor<UsersDao> usersDaoConstructor = usersDaoClass.getConstructor(Connection.class);
            UsersDao usersDao = usersDaoConstructor.newInstance(getConnection());
            return usersDao;
        }
        throw new IllegalArgumentException("Can't instantiate  DAO");
    }

    private UsersService getUsersService() throws ReflectiveOperationException {
        String usersServiceClassName = properties.getProperty("users.service.class");
        Class<UsersService> usersServiceClass = (Class<UsersService>)
                Class.forName(usersServiceClassName);
        Constructor<UsersService> usersServiceConstructor =
                usersServiceClass.getConstructor(UsersDao.class);
        UsersService usersService =
                usersServiceConstructor.newInstance(getUsersDao());
        return usersService;
    }

    // TODO: сделать на JDBC
    private AutoDao getAutoDao() throws ReflectiveOperationException {
        if (daoProfile.equals("files")) {
            String autoDaoClassName = properties.getProperty("auto.dao.class");
            String daoFileName = properties.getProperty("autos.file");
            Class<AutoDao> autoDaoClass = (Class<AutoDao>) Class.forName(autoDaoClassName);
            Constructor<AutoDao> autoDaoConstructor = autoDaoClass.getConstructor(String.class, FileDaoQueryTemplate.class);
            AutoDao autoDao = autoDaoConstructor.newInstance(daoFileName, getFileDaoQueryTemplate());
            return autoDao;
        } else if (daoProfile.equals("jdbc")){
            String autoDaoClassName = properties.getProperty("auto.jdbc.dao.class");
            Class<AutoDao> autoDaoClass = (Class<AutoDao>) Class.forName(autoDaoClassName);
            Constructor<AutoDao> autoDaoConstructor = autoDaoClass.getConstructor(Connection.class);
            AutoDao autoDao = autoDaoConstructor.newInstance(getConnection());
            return autoDao;
        }
        throw new IllegalArgumentException("Can't instantiate  auto DAO");
    }

    private Connection getConnection() throws ReflectiveOperationException {
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driver = properties.getProperty("jdbc.driver");
        Class.forName(driver);
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}