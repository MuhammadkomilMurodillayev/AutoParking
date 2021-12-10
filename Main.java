package parking;

import static parking.utils.MyUtils.strip;
import static parking.utils.Print.println;
import static parking.db.MyDB.session;
import static parking.utils.Colors.*;
import static parking.utils.Input.getStr;
import static parking.db.MyDB.loggedIn;
import static parking.db.MyDB.init;
import static parking.services.UserService.*;
import static parking.services.ParkService.*;
import static parking.services.OrganizationService.*;

public class Main {
    public static void main(String[] args) {
        init();
        run();
    }

    private static void run() {
        menu();
        String choice = getStr("Select an option: ");
        if (choice.equals("1") && !loggedIn) {
            login();
        } else if (choice.equals("1") && !session.isAdmin() && session.isSuperA()) {
            showOrganizations();
        } else if (choice.equals("2") && !session.isAdmin() && session.isSuperA()) {
            creatOrganization();
        } else if (choice.equals("3") && !session.isAdmin() && session.isSuperA()) {
            deleteOrganization();
        } else if (choice.equals("4") && !session.isAdmin() && session.isSuperA()) {
            blockOrganization();
        } else if (choice.equals("5") && !session.isAdmin() && session.isSuperA()) {
            unblockOrganization();
        } else if (choice.equals("6") && !session.isAdmin() && session.isSuperA()) {
            creatUseer();
        } else if (choice.equals("7") && !session.isAdmin() && session.isSuperA()) {
            logout();

        } else if (choice.equals("1") && !session.isSuperA()) {
            showFreeSpaces();
        } else if (choice.equals("2") && !session.isSuperA()) {
            // IN
        } else if (choice.equals("3") && !session.isSuperA()) {
            // out
        } else if (choice.equals("4") && !session.isSuperA()) {
            changePassword();
        } else if (choice.equals("5") && !session.isSuperA()) {
            logout();
        } else if (choice.equals("6") && session.isAdmin() && !session.isSuperA()) {
            createPark();
        } else if (choice.equals("7") && session.isAdmin() && !session.isSuperA()) {
            deletePark();
        } else if (choice.equals("8") && session.isAdmin() && !session.isSuperA()) {
            blockPark();
        } else if (choice.equals("9") && session.isAdmin() && !session.isSuperA()) {
            unblockPark();
        } else if (choice.equals("10") && session.isAdmin() && !session.isSuperA()) {
            showParks();
        } else if (choice.equals("11") && session.isAdmin() && !session.isSuperA()) {
            creatUseer();
        } else if (choice.equals("12") && session.isAdmin() && !session.isSuperA()) {
            deletUser();
        } else if (choice.equals("13") && session.isAdmin() && !session.isSuperA()) {
            blockUser();
        } else if (choice.equals("14") && session.isAdmin() && !session.isSuperA()) {
            unblockUser();
        } else if (choice.equals("15") && session.isAdmin() && !session.isSuperA()) {
            String opt = getStr("1. All users\n2.Blocked\n? : ");
            if (opt.equals("1")) {
                showUsers();
            } else if (opt.equals("2")) {
                showBlockedUsers();
            } else {
                println(RED, "Wrong input.");
            }
        } else if (choice.startsWith("e")) {
            println(RED, "Goodbye");
            return;
        } else {
            println(RED, "Wrong selection");
        }
        run();
    }

    private static void menu() {
        strip();
        if (loggedIn) {
            if (session.isSuperA()) {
                println(BLUE, "1. Show Organizations");
                println(BLUE, "2. Create Organiztion");
                println(BLUE, "3. Delete Organiztion");
                println(BLUE, "4. Block Organiztion");
                println(BLUE, "5. Unblock Organiztion");
                println(BLUE, "6. Create Admin");
                println(BLUE, "7. Logout");
            } else if (!session.isBlocked()) {
                println(BLUE, "1. Free Spaces");
                println(BLUE, "2. In");
                println(BLUE, "3. Out");
                println(BLUE, "4. Change password");
                println(BLUE, "5. Logout");
                if (session.isAdmin()) {
                    println(GREEN, "~~~~~~~>Park Services<~~~~~~");
                    println(BLUE, "6. Create Park");
                    println(BLUE, "7. Delete Park");
                    println(BLUE, "8. Block Park");
                    println(BLUE, "9. UnBlock Park");
                    println(BLUE, "10. Show Parks");
                    println(GREEN, "~~~~~~~>User Services<~~~~~~");
                    println(BLUE, "11. Create User");
                    println(BLUE, "12. Delete User");
                    println(BLUE, "13. Block User");
                    println(BLUE, "14. Unblock User");
                    println(BLUE, "15. Show Users");
                }
            }
        } else {
            println(YELLOW, "1. Login");
        }
        println(CYAN, ">E<.EXIT");
        strip();
    }
}
