package com.example.ticketnow.models;

public class ProfileModel {

    String userName;
    String userEmail;
    String userID;
    String userNumber;
    String userAddress;

    public ProfileModel() {
    }

    public ProfileModel(String userName, String userEmail, String userID, String userNumber, String userAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userID = userID;
        this.userNumber = userNumber;
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
