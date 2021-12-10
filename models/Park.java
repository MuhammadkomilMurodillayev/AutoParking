package parking.models;

import java.util.ArrayList;

import parking.models.Floor;

public class Park {
    private String name;
    private int floorCount;
    private boolean blocked;
    private int rowCount;
    private int cellCount;
    private String id;
    private ArrayList<Floor> floors = new ArrayList<>();

    public Park(String name, int floorCount, int rowCount, int cellCount, ArrayList<Floor> floors) {

        this.name = name;
        this.floorCount = floorCount;
        this.rowCount = rowCount;
        this.cellCount = cellCount;
        this.floors = floors;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public Park() {
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public Park(String name) {
        this();
        this.name = name;
    }

    public Park(String name, ArrayList<Floor> floors) {
        this(name);
        this.floors = floors;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Floor> getFloors() {
        return this.floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public Park name(String name) {
        setName(name);
        return this;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Park floors(ArrayList<Floor> floors) {
        setFloors(floors);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", floors='" + getFloors() + "'" + "}";
    }

}
