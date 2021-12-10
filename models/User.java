package parking.models;

import static parking.utils.MyUtils.genUniqueID;

public class User {
    private String id;
    private String parkId;
    private String orgId;
    private String username;
    private String password;
    private String workplace;
    private boolean admin;
    private boolean blocked;
    private boolean superA;

    public User() {
        this.id = genUniqueID();
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkId() {
        return this.parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isSuperA() {
        return this.superA;
    }

    public boolean getSuperA() {
        return this.superA;
    }

    public void setSuperA(boolean superA) {
        this.superA = superA;
    }

    public User id(String id) {
        setId(id);
        return this;
    }

    public User parkId(String parkId) {
        setParkId(parkId);
        return this;
    }

    public User orgId(String orgId) {
        setOrgId(orgId);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User admin(boolean admin) {
        setAdmin(admin);
        return this;
    }

    public User blocked(boolean blocked) {
        setBlocked(blocked);
        return this;
    }

    public User superA(boolean superA) {
        setSuperA(superA);
        return this;
    }

    @Override
    public String toString() {
        return "{" + ", username= " + getUsername() + ", admin= " + isAdmin() + ", blocked= " + isBlocked() + "}";
    }
}
