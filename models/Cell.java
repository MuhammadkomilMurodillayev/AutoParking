package parking.models;

public class Cell {
    private String rowName;
    private Car car;

    public Cell() {
    }

    public Cell(String rowName) {
        this.rowName = rowName;
    }

    public Cell(String rowName, Car car) {
        this(rowName);
        this.car = car;
    }

    public String getRowName() {
        return this.rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
