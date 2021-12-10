package parking.services;

import static parking.utils.Input.getNum;
import static parking.utils.Input.getStr;
import static parking.utils.Print.println;
import static parking.utils.Colors.*;
import static parking.db.MyDB.*;
import static parking.services.OrganizationService.showParks;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import parking.models.Car;
import parking.models.Cell;
import parking.models.Floor;
import parking.models.Park;
import parking.models.Row;

import static parking.utils.Print.print;

public class ParkService {

    public static void showFreeSpaces() {
        Park park1 = new Park();
        if (session.isAdmin()) {
            showParks();
            String parkName = getStr("Which park: ");
            if (Objects.isNull(findParkByName(parkName))) {
                print(RED, "Wrong choice");
                return;
            }
            park1 = findParkByName(parkName);
        } else {
            park1 = findParkByName(session.getWorkplace());
        }
        println("");
        ArrayList<Floor> floors = park1.getFloors();
        for (int i = 0; i < floors.size(); i++) {
            Floor floor = floors.get(i);
            println(RED, (i + 1) + "-Floor");
            print("\t");
            for (int j = 0; j < park1.getCellCount(); j++) {
                print(PURPLE, (j + 1) + "\t");
            }
            println("");
            for (Row row : floor.getRows()) {
                print(PURPLE, row.getName() + "\t");
                for (Cell cell : row.getCells()) {
                    if (cell.getCar() == null)
                        print(GREEN, "✅\t");
                    else
                        print(RED, "❌\t");
                }
                println("");
            }
        }
    }

    private static Park findParkByName(String parkName) {
        for (Park park : parks) {
            if (Objects.nonNull(park) && park.getName().equals(parkName))
                return park;
        }
        return null;
    }

    // public static void in() {
    // int floorIndex = getNum("floor ");
    // Floor floor = park.getFloors().get(floorIndex - 1);
    // if (!checkForEmptyCell(floor.getRows())) {
    // println(RED, "Sorry bro there is no place on this floor");
    // return;
    // }
    // String number = getStr("number ");
    // int time = getNum("time ");
    // putCar(floor, number, time);
    // }

    // public static void out() {
    // String[] arr = getStr("Qr ?:").toLowerCase().split("_");
    // int floorIndex = Integer.parseInt(arr[0]) - 1;
    // int rowIndex = getRowIndex(arr[1].charAt(0));
    // int cellIndex = Integer.parseInt(arr[2]) - 1;
    // if (floorIndex >= park.getFloorCount() || rowIndex >= park.getRowCount() ||
    // cellIndex >= park.getCellCount()) {
    // println(RED, "Qr is invalid");
    // return;
    // }
    // park.getFloors().get(floorIndex).getRows().get(rowIndex).getCells().get(cellIndex).setCar(null);
    // }

    // private static int getRowIndex(char a) {
    // int r = a - 'a';
    // return r >= 0 && r < park.getRowCount() ? r : -1;
    // }

    // private static void putCar(Floor floor, String number, int time) {
    // Car car = new Car(number, time);
    // Random random = new Random();
    // int rowIndex = random.nextInt(park.getRowCount());
    // int cellIndex = random.nextInt(park.getCellCount());
    // ArrayList<Row> rows = floor.getRows();
    // if (rows.get(rowIndex).getCells().get(cellIndex).getCar() == null) {
    // rows.get(rowIndex).getCells().get(cellIndex).setCar(car);
    // println(RED, floor.getFloor() + "_" + rows.get(rowIndex).getRowName() + "_" +
    // (cellIndex + 1));
    // return;
    // }
    // putCar(floor, number, time);
    // }

    // private static boolean checkForEmptyCell(ArrayList<Row> rows) {
    // for (Row row : rows) {
    // for (Cell cell : row.getCells()) {
    // if (cell.getCar() == null)
    // return true;
    // }
    // }
    // return false;
    // }
}
