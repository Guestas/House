package com.mc.House.entity.Helpers;

import com.mc.House.entity.User;

public class UserAddHelper {
    private String username;
    private String email;
    private Integer phone;
    private Boolean owner;
    private int apartment;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public UserAddHelper(String username, String email, Integer phone, Boolean owner, int apartment) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.owner = owner;
        this.apartment = apartment;
    }

    public UserAddHelper() {

    }

    public User getUser(){
        return new User(username, email, phone, owner);
    }
    public int getApartment(){
        return apartment;
    }

    @Override
    public String toString() {
        return "UserAddHelper{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", owner=" + owner +
                ", apartment=" + apartment +
                '}';
    }
}
