package ru.itis;

import java.io.*;

public class UsersDaoTextFileBasedImpl implements UsersDao {

    BufferedReader reader;

    public UsersDaoTextFileBasedImpl(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User[] findAll() {
        User users[] = new User[10];
        try {
            String currentUser = reader.readLine();
            int i = 0;
            while (currentUser != null) {
                String userData[] = currentUser.split(" ");
                int userId = Integer.parseInt(userData[0]);
                String userName = userData[1];
                users[i] = new User(userId, userName);
                currentUser = reader.readLine();
                i++;
            }
            return users;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
