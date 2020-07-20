package com.ssx.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int userID;
    private String addressID;
    private String userName;
    private List<Address> Address;

    public List<com.ssx.bean.Address> getAddress() {
        return Address;
    }

    public void setAddress(List<com.ssx.bean.Address> address) {
        Address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", addressID='" + addressID + '\'' +
                ", userName='" + userName + '\'' +
                ", Address=" + Address +
                '}';
    }
}
