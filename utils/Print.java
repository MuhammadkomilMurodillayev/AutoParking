package parking.utils;

import static parking.utils.Colors.RESET;

public class Print {
    public static void print(String color, Object obj) {
        System.out.print(color + obj + RESET);
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(String color, Object obj) {
        System.out.println(color + obj + RESET);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }
}
