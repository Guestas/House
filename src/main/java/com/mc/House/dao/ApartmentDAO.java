package com.mc.House.dao;

import com.mc.House.entity.Apartment;

import java.util.List;

public interface ApartmentDAO {
    Apartment updateHouseMeeting(Apartment apartement);

    Apartment findById(Integer id);
    List<Apartment> findAll();

}
