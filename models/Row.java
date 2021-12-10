package parking.models;

import java.util.ArrayList;

public class Row {
    private String name;
    private ArrayList<Cell> cells = new ArrayList<>();

    public Row() {
    }

    public Row(String name) {
        this.name = name;
    }

    public Row(String name, ArrayList<Cell> cells) {
        this(name);
        this.cells = cells;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cell> getCells() {
        return this.cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }
}