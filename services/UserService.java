package parking.services;

import static parking.utils.Input.getStr;
import static parking.utils.Print.println;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static parking.utils.Colors.*;

import parking.models.User;
//import uz.jl.utils.BaseUtil;

import static parking.db.MyDB.users;
import static parking.db.MyDB.loggedIn;
import static parking.db.MyDB.session;

public class UserService {

    public static void login() {
        String username = getStr("Enter username: ");
        String password = getStr("Enter password: ");
        User user = findUserByName(username);
        if (user == null || !user.getPassword().equals(password)) {
            println(RED, "Wrong username or password.");
            return;
        }
        if (user.isBlocked()) {
            println(RED, "You are blocked");
            return;
        }
        println(GREEN, "Welcom");
        session = user;
        loggedIn = true;
    }

    public static User findUserByName(String username) {
        for (User user : users) {
            if (Objects.nonNull(user) && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void showUsers() {
        AtomicInteger index = new AtomicInteger(1);
        for (User user : users) {
            println(CYAN, index.getAndIncrement() + ". " + user);
        }
    }

    public static void showBlockedUsers() {
        AtomicInteger index = new AtomicInteger(1);
        for (User user : users) {
            if (user.isBlocked()) {
                println(CYAN, index.getAndIncrement() + ". " + user);
            }
        }
        if (index.equals(1))
            println(RED, "There is no blocked users");

    }

    public static void creatUseer() {
        String username = getStr("Enter username: ");
        String password = getStr("Enter password: ");
        if (Objects.nonNull(findUserByName(username))) {
            println(RED, "Username already taken");
            return;
        }
        String status = getStr("Admin?\n yes or no: ").toLowerCase();
        User newUser = new User(username, password);
        if (status.startsWith("y")) {
            users.add(newUser.admin(true));
            println(GREEN, "Created Admin");
            return;
        }
        users.add(newUser.admin(false));
        String workplace = getStr("Workplace : ");
        newUser.setWorkplace(workplace);
        println(GREEN, "Created User");

    }

    public static void deletUser() {
        String username = getStr("Enter username: ");
        User user = findUserByName(username);
        if (Objects.isNull(user)) {
            println(RED, "User not found");
        }
        users.remove(user);
    }

    public static void changePassword() {
        if (session.isAdmin()) {
            String username = getStr("Username ");
            User user = findUserByName(username);
        } else {
            String oldPassword = getStr("Old Password");
            String newPassword = getStr("New Password");
            String confirmPassword = getStr("Confirm Password");
            if (!session.getPassword().equalsIgnoreCase(oldPassword)) {
                println(RED, "Bad credentials");
                return;
            }
            if (!newPassword.equals(confirmPassword)) {
                println(RED, "Password does not match");
                return;
            }
            session.setPassword(newPassword);
            println(GREEN, "Your credentials have reset please login");
            session = null;
            loggedIn = false;
        }
    }

    public static void blockUser() {
        String username = getStr("Username : ");
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setBlocked(true);
                println(GREEN, "Blocked");
                return;
            }
        }
        println(RED, "User not found");
    }

    public static void unblockUser() {
        String username = getStr("Username : ");
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setBlocked(false);
                println(GREEN, "Unblocked");
                return;
            }
        }
        println(RED, "User not found");
    }

    public static void logout() {
        println(RED, "Bye");
        session = null;
        loggedIn = false;
    }
}
