package com.mc.House.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="user-name")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private Integer phone;
    @Column(name="owner")
    private Boolean owner;

    @ManyToOne//(cascade = CascadeType.DETACH)//if you need some cascading default is none //one to many and so on
    @JoinColumn(name="apartment_id")
    private Apartment apartment;

    public User(){}
    public User(String username, String email, Integer phone, Boolean owner,Apartment apartment) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.owner = owner;
        this.apartment = apartment;
    }

    public User(String username, String email, Integer phone, Boolean owner) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.owner = owner;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }



    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"username\":\"" + username + "\"" +
                ", \"email\":\"" + email + "\"" +
                ", \"phone\":" + phone +
                ", \"owner\":" + owner +
                "}";
    }

}
