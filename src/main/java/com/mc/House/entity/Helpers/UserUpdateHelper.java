package com.mc.House.entity.Helpers;

import com.mc.House.entity.User;

public class UserUpdateHelper extends UserAddHelper{
    private int id;
    public UserUpdateHelper(int id, String username, String email, Integer phone, Boolean owner, int apartment) {
        super(username, email, phone, owner, apartment);
        this.id = id;
    }

    @Override
    public User getUser() {
        User temp = super.getUser();
        temp.setId(id);
        return temp;
    }

    @Override
    public int getApartment() {
        return super.getApartment();
    }

    @Override
    public String toString() {
        return "UserUpdateHelper{" +
                "id=" + id +
                super.toString()+
                '}';
    }
}
