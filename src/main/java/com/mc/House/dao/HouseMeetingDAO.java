package com.mc.House.dao;

import com.mc.House.dto.HouseMeetingSmall;
import com.mc.House.entity.HouseMeeting;

import java.util.List;

public interface HouseMeetingDAO {
    HouseMeeting saveUpdate(HouseMeeting houseMeeting);
    HouseMeeting findById(Integer id);
    List<HouseMeetingSmall> findAllSmall();
}
