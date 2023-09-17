package com.mc.House.service;

import com.mc.House.entity.HouseMeeting;

import java.util.List;

public interface HouseMeetingService {
    public List<HouseMeeting> findAll();

    public HouseMeeting findById(Integer id);

    HouseMeeting save(HouseMeeting houseMeeting);

}
