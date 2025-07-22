package com.example.prototypeapplication.Model;

public class UsersData {
    private int id;
    private String name;
    private String passw;
    private int role;

    public UsersData(int id, String name, String passw, int role) {
        this.id = id;
        this.name = name;
        this.passw = passw;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
