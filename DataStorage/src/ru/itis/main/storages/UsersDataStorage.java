package ru.itis.main.storages;

import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UsersDataStorage {

    // поле, в котором хранится имя файла
    // в котором содежатся данные о пользователях
    private String fileName;
    private IdGenerator idGenerator;

    public UsersDataStorage(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    public int save(User user) {
        try {
            user.setId(idGenerator.generateId());
//            FileOutputStream outputStream =
//                    new FileOutputStream(fileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));
            String userDataAsString = user.toString();
            bufferedWriter.write(userDataAsString + "\n");
            bufferedWriter.close();
            return user.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
    }

    public User find(int id) {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String currentUserData = reader.readLine();

            while (currentUserData != null) {
                String currentUserDataAsArray[] =
                        currentUserData.split(" ");

                int currentUserId =
                        Integer.parseInt(currentUserDataAsArray[0]);

                if (currentUserId == id) {
                    User founded = new User(
                            currentUserDataAsArray[1],
                            currentUserDataAsArray[2],
                            currentUserDataAsArray[3],
                            Integer.parseInt(currentUserDataAsArray[4]));
                    founded.setId(id);
                    reader.close();
                    return founded;
                }
                currentUserData = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");

        }

        // TODO: создать Exception UserNotFoundException наследованный от Runtime
        // TODO: выбросить UserNotFound


        throw new UserNotFoundException("User with id: " + id + " not found");

    }

    public List<User> findAll() {
        ArrayList<User> allUsers = new ArrayList<>();
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            String currentUserData = reader.readLine();
            while (currentUserData != null) {
                String currentUserDataAsArray[] =
                        currentUserData.split(" ");

                int currentUserId =
                        Integer.parseInt(currentUserDataAsArray[0]);

                User founded = new User(
                        currentUserDataAsArray[1],
                        currentUserDataAsArray[2],
                        currentUserDataAsArray[3],
                        Integer.parseInt(currentUserDataAsArray[4]));
                founded.setId(currentUserId);
                allUsers.add(founded);
                currentUserData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return allUsers;
    }

    public void delete(int id) {

        List<User> buffer = findAll();
        int indexOfDeleted = -1;
        for (int i = 0; i < buffer.size(); i++) {
            User currentUser = buffer.get(i);
            if (currentUser.getId() == id) {
                indexOfDeleted = i;
                break;
            }
        }
                if (indexOfDeleted > -1) {
                       buffer.remove(indexOfDeleted);
        }

        flushFromBuffer(buffer);
    }
    public void update(User user) {
        List<User> buffer = findAll();
        int idOfUpdatedUser = user.getId();
        for(int i =0;i<buffer.size();i++) {
            User currentUser = buffer.get(i);
            if (currentUser.getId()==idOfUpdatedUser) {
                buffer.set(i, user);
                return;
            }
        }
        flushFromBuffer(buffer);
    }
    private void flushFromBuffer(List<User> buffer) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileName));

            for (int i = 0; i < buffer.size(); i++) {
                writer.write(buffer.get(i).toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }

}
