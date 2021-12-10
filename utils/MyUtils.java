package parking.utils;

import java.util.UUID;
import static parking.utils.Print.println;
import static parking.utils.Colors.YELLOW;

public class MyUtils {
    public static String genUniqueID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void strip() {
        println(YELLOW, "__________________________");
    }
}
