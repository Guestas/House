package com.mc.House.dao;

import com.mc.House.dto.ApartmentSmall;
import com.mc.House.dto.HouseMeetingSmall;
import com.mc.House.entity.Apartment;

import java.util.List;

public interface ApartmentDAO {
    Apartment updateHouseMeeting(Apartment apartement);

    List<ApartmentSmall> findAllSmall();

    Apartment findById(Integer id);

}
