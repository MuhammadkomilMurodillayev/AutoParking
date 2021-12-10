package parking.utils;

import java.util.Scanner;
import static parking.utils.Print.print;

public class Input {
    public static final Scanner SCANNER_STR = new Scanner(System.in);
    public static final Scanner SCANNER_NUM = new Scanner(System.in);

    public static String getStr(String str) {
        print(str);
        return SCANNER_STR.nextLine();
    }

    public static String getStr() {
        return getStr("");
    }

    public static int getNum(String str) {
        print(str);
        return SCANNER_NUM.nextInt();
    }

    public static int getNum() {
        return getNum("");
    }
}
