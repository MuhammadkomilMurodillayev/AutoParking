package parking.models;

public class Car {
    private String id;
    private String number;
    private String inAt;
    private String outAt;

    public Car() {
        this.id = id;
    }

    public Car(String id, String number, String inAt) {
        this();
        this.number = number;
        this.inAt = inAt;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInAt() {
        return this.inAt;
    }

    public void setInAt(String inAt) {
        this.inAt = inAt;
    }

    public String getOutAt() {
        return this.outAt;
    }

    public void setOutAt(String outAt) {
        this.outAt = outAt;
    }

    public Car id(String id) {
        setId(id);
        return this;
    }

    public Car number(String number) {
        setNumber(number);
        return this;
    }

    public Car inAt(String inAt) {
        setInAt(inAt);
        return this;
    }

    public Car outAt(String outAt) {
        setOutAt(outAt);
        return this;
    }

    @Override
    public String toString() {
        return "{ number= " + getNumber() + ", inAt= " + getInAt() + ", outAt= " + getOutAt() + "}";
    }

}
