package com.mc.House.dto;

import com.mc.House.entity.HouseMeeting;

import java.util.List;

public class HouseMeetingSmall {
    private Integer id;
    private String date, name;

    public HouseMeetingSmall(Integer id, String date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
