package com.example.ticketnow.models;

public class UserModel {

    String userID;
    String userEmail;
    String userPhone;
    String userPassword;
    String userConfPassword;

    public UserModel() {
    }

    public UserModel(String userID, String userEmail, String userPhone, String userPassword, String userConfPassword) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userConfPassword = userConfPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserConfPassword() {
        return userConfPassword;
    }

    public void setUserConfPassword(String userConfPassword) {
        this.userConfPassword = userConfPassword;
    }
}
