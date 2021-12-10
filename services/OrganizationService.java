package parking.services;

import static parking.db.MyDB.organizations;
import static parking.db.MyDB.session;
import static parking.db.MyDB.parks;
import static parking.utils.Input.getStr;
import static parking.utils.Input.getNum;
import static parking.utils.Print.println;
import static parking.services.UserService.findUserByName;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static parking.utils.Colors.*;

import parking.models.Cell;
import parking.models.Floor;
import parking.models.Organization;
import parking.models.Park;
import parking.models.Row;
import parking.models.User;
//import uz.jl.utils.BaseUtil;

public class OrganizationService {
   public static void creatOrganization() {
      String name = getStr("Enter name of organizatrion:");
      Organization organization = checkNameExistance(name);
      if (Objects.nonNull(organization)) {
         println(RED, "This name already taken");
         return;
      }
      String ownername = getStr("Enter organization's owner: ");
      User owner = findUserByName(ownername);
      if (Objects.isNull(owner)) {
         println(RED, "User notv found");
         creatOrganization();
      }
      organization.setOwnerId(owner.getId());
      println(GREEN, "Successfully created organization.");
   }

   private static Organization checkNameExistance(String name) {
      for (Organization organization : organizations) {
         if (organization.getName().equals(name)) {
            return organization;
         }
      }
      return null;
   }

   public static void showOrganizations() {
      AtomicInteger index = new AtomicInteger(1);
      for (Organization organization : organizations) {
         if (Objects.nonNull(organization)) {
            println(index.getAndIncrement() + organization.getName());
         }
      }
      if (index.equals(1)) {
         println(RED, "There is no organization");
      }
   }

   public static void deleteOrganization() {
      showOrganizations();
      String orgName = getStr("Enter organization's name: ");
      if (Objects.isNull(checkNameExistance(orgName))) {
         println(RED, "Organization not foun with name");
      }
      organizations.remove(checkNameExistance(orgName));
      println(GREEN, "Orhanization deleted.");
   }

   public static void blockOrganization() {
      showOrganizations();
      String orgName = getStr("Enter organization's name: ");
      if (Objects.isNull(checkNameExistance(orgName))) {
         println(RED, "Organization not foun with name");
      }
      checkNameExistance(orgName).setBlocked(true);
      println(GREEN, "Orhanization blocked.");
   }

   public static void unblockOrganization() {
      showOrganizations();
      String orgName = getStr("Enter organization's name: ");
      if (Objects.isNull(checkNameExistance(orgName))) {
         println(RED, "Organization not foun with name");
      }
      checkNameExistance(orgName).setBlocked(false);
      println(GREEN, "Orhanization unblocked.");
   }

   public static void createPark() {
      String name = getStr("Enter park name: ");
      if (Objects.nonNull(checkParkByName(name))) {
         println(RED, "Name already taken");
         return;
      }
      int numFloor = getNum("Floors: ");
      int numRows = getNum("Rows: ");
      int numCells = getNum("Cells: ");
      Park park = new Park();
      park=getPark(name, numFloor, numRows, numCells);
      park.setId(session.getId());
      parks.add(park);
      println("Park created successfully!");
   }

   private static Park getPark(String name, int numFloors, int numRows, int numCells){
      Park park=new Park();
      ArrayList<Floor> floors=new ArrayList<>();
      for (int i = 0; i < numFloors; i++) {
         floors.add(getFloor(numRows,numCells));
      }
      park.setFloors(floors);
      return park;
   }
   private static Floor getFloor(int numRows,int numCells){
      Floor floor=new Floor();
      ArrayList<Row> rows=new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
         rows.add(getRow(numCells));
      }
      floor.setRows(rows);
      return floor;
   }

   private static Row getRow(int numCells){
      Row row=new Row();
      ArrayList<Cell> cells=new ArrayList<>();
      for (int i = 0; i < numCells; i++) {
         cells.add(new Cell());
      }
      row.setCells(cells);
      return row;
   }
   private static Park checkParkByName(String name) {
      for (Park park : parks) {
         if (park.getName().equals(name)) {
            return park;
         }
      }
      return null;
   }

   public static void deletePark() {
      showOrganizations();
      String name = getStr("Enter name of park: ");
      if (Objects.isNull(checkParkByName(name))) {
         println(RED, "Park not found");
         return;
      }
      parks.remove(checkNameExistance(name));
      println(GREEN, "Deleted park");
   }

   public static void showParks() {
      AtomicInteger index = new AtomicInteger(1);
      for (Park park : parks) {
         if (Objects.nonNull(park)) {
            println(index + ". " + park);
         }
      }
      if (index.equals(1)) {
         println(RED, "There no parks");
      }
   }

   public static void blockPark() {
      showOrganizations();
      String parkName = getStr("Enter parks name: ");
      if (Objects.isNull(checkParkByName(parkName))) {
         println(RED, "Park not foun with name");
      }
      checkNameExistance(parkName).setBlocked(true);
      println(GREEN, "Park blocked.");
   }

   public static void unblockPark() {
      showParks();
      String parkNmae = getStr("Enter parks name: ");
      if (Objects.isNull(checkParkByName(parkNmae))) {
         println(RED, "Park not foun with name");
      }
      checkParkByName(parkNmae).setBlocked(false);
      println(GREEN, "Park unblocked.");
   }

}
