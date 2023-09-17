package com.mc.House.service;

import com.mc.House.dao.HouseMeetingDAO;
import com.mc.House.entity.HouseMeeting;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseMeetingServiceImpl implements HouseMeetingService {

    private final HouseMeetingDAO houseMeetingDAO;

    public HouseMeetingServiceImpl(HouseMeetingDAO houseMeetingDAO){
        this.houseMeetingDAO = houseMeetingDAO;
    }

    @Override
    public List<HouseMeeting> findAll() {
        return houseMeetingDAO.findAll();
    }

    @Override
    public HouseMeeting findById(Integer id) {
        return houseMeetingDAO.findById(id);
    }

    @Override
    @Transactional
    public HouseMeeting save(HouseMeeting houseMeeting) {
        System.out.println(houseMeeting);
        return houseMeetingDAO.saveUpdate(houseMeeting);
    }

}
