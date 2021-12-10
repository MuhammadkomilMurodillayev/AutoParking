package parking.models;

import java.util.ArrayList;
import parking.models.Row;

public class Floor {
    public Floor(){}
    private int floor;
    private ArrayList<Row> rows = new ArrayList<>();

    public Floor(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ArrayList<Row> getRows() {
        return this.rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public Floor floor(int floor) {
        setFloor(floor);
        return this;
    }

    public Floor rows(ArrayList<Row> rows) {
        setRows(rows);
        return this;
    }
}
