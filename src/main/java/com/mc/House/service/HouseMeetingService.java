package com.mc.House.service;

import com.mc.House.dto.HouseMeetingSmall;
import com.mc.House.entity.HouseMeeting;

import java.util.List;

public interface HouseMeetingService {

    List<HouseMeetingSmall> findAllSmall();

    public HouseMeeting findById(Integer id);

    HouseMeeting save(HouseMeeting houseMeeting);

}
