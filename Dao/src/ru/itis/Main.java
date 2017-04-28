package ru.itis;

public class Main {

    public static void main(String[] args) {
        UsersDao usersDao = new UsersDaoTextFileBasedImpl("users.txt");
	    UsersService service = new UsersService(usersDao);

        System.out.println(service.isRegistered("Masha"));
    }
}
