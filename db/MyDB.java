package parking.db;

import java.util.ArrayList;

import parking.models.Organization;
import parking.models.Park;
import parking.models.User;

public class MyDB {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Organization> organizations = new ArrayList<>();
    public static ArrayList<Park> parks = new ArrayList<>();
    public static User session;
    public static boolean loggedIn;

    public static void init() {
        User superviser = new User("nodir", "123");
        superviser.setSuperA(true);
        users.add(superviser);
    }
}
