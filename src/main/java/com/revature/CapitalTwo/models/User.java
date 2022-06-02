package com.revature.CapitalTwo.models;

public class User {
    private String id;
    private String name;
    private String address;
    private String state;
    private String username;
    private String password;
    private int annual_sal;

    public User(String id, String name, String address, String state, String username, String password, int annual_sal) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.state = state;
        this.username = username;
        this.password = password;
        this.annual_sal = annual_sal;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", annual_sal=" + annual_sal +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAnnual_sal() {
        return annual_sal;
    }

    public void setAnnual_sal(int annual_sal) {
        this.annual_sal = annual_sal;
    }
}
