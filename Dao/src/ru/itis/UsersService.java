package ru.itis;


public class UsersService {

    private UsersDao usersDao;

    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    public boolean isRegistered(String name) {
        // получить массив пользователей
        User users[] = usersDao.findAll();

        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
