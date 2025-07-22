package com.example.unflapl;

public class users {

    private int id;
    private String userName;
    private String userPassword;

    // Constructor with all fields (for future use if you need the fullName)
    public users(int id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    // Constructor with username and password (this will be used for signup)
    public users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
