package com.mc.House.service;

import com.mc.House.dao.ApartmentDAO;
import com.mc.House.dao.HouseMeetingDAO;
import com.mc.House.dto.ApartmentSmall;
import com.mc.House.entity.Apartment;
import com.mc.House.entity.HouseMeeting;
import com.mc.House.rest.exceptions.DataNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImp implements ApartmentService{
    private final ApartmentDAO apartmentDAO;
    private final HouseMeetingDAO houseMeetingDAO;
    public ApartmentServiceImp(ApartmentDAO apartmentDAO, HouseMeetingDAO houseMeetingDAO){
        this.apartmentDAO = apartmentDAO;
        this.houseMeetingDAO = houseMeetingDAO;
    }
    @Override
    public Apartment findByApartmentId(int num) {
        return apartmentDAO.findById(num);
    }

    @Override
    public List<ApartmentSmall> findAllSmall() {
        return apartmentDAO.findAllSmall();
    }

    @Override
    @Transactional
    public Apartment addApartmentHouseMeeting(int apartmentId, int houseMeetingId) {
        Apartment a = apartmentDAO.findById(apartmentId);
        HouseMeeting h = houseMeetingDAO.findById(houseMeetingId);
        if (a==null)
            throw new DataNotFoundException("apartment not found");
        if(h==null)
            throw new DataNotFoundException("house meeting not found");
        a.addHouseMeeting(h);

        return apartmentDAO.updateHouseMeeting(a);
    }
}
