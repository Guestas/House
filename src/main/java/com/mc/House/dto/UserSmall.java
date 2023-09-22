package com.mc.House.dto;

public class UserSmall {
    private Integer id;
    private String username;
    private String email;
    private Integer phone;

    public UserSmall() {
    }

    public UserSmall(Integer id, String username, String email, Integer phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}
