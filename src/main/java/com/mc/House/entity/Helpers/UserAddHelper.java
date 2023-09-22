package com.mc.House.entity.Helpers;

import com.mc.House.entity.User;

public class UserAddHelper {
    private String username;
    private String email;
    private Integer phone;
    private Boolean owner;
    private int apartment;


    public UserAddHelper(String username, String email, Integer phone, Boolean owner, int apartment) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.owner = owner;
        this.apartment = apartment;
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
