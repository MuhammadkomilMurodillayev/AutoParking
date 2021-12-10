package parking.models;

import java.util.ArrayList;
import static parking.utils.MyUtils.genUniqueID;

public class Organization {
    private String id;
    private String ownerId;
    private String name;
    private ArrayList<Park> parks = new ArrayList<>();
    private boolean blocked;

    public Organization() {
        this.id = genUniqueID();
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Organization(String name) {
        this();
        this.name = name;
    }

    public Organization(String name, String ownerId) {
        this(name);
        this.ownerId = ownerId;
    }

    public Organization(String name, String ownerId, ArrayList<Park> parks) {
        this(name, ownerId);
        this.parks = parks;
    }

    public String getOwner() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Park> getParks() {
        return this.parks;
    }

    public void setParks(ArrayList<Park> parks) {
        this.parks = parks;
    }

    public Organization name(String name) {
        setName(name);
        return this;
    }

    public Organization id(String id) {
        setId(id);
        return this;
    }

    public Organization parks(ArrayList<Park> parks) {
        setParks(parks);
        return this;
    }

}
