package com.mc.House.service;

import com.mc.House.dao.ApartmentDAO;
import com.mc.House.dto.ApartmentSmall;
import com.mc.House.dto.HouseMeetingSmall;
import com.mc.House.entity.Apartment;
import com.mc.House.entity.User;

import java.util.List;

public interface ApartmentService {
    Apartment findByApartmentId(int num);

    List<ApartmentSmall> findAllSmall();

    Apartment addApartmentHouseMeeting(int apartmentId, int houseMeetingId);
}
