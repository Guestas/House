package com.mc.House.dao;

import com.mc.House.entity.HouseMeeting;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseMeetingDAOImpl implements HouseMeetingDAO{
    private EntityManager entityManager;
    @Autowired
    public HouseMeetingDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public HouseMeeting saveUpdate(HouseMeeting houseMeeting) {
        entityManager.merge(houseMeeting);
        return houseMeeting;
    }

    @Override
    public HouseMeeting findById(Integer id) {
        return entityManager.find(HouseMeeting.class, id);
    }

    @Override
    public List<HouseMeeting> findAll() {
        TypedQuery<HouseMeeting> query = entityManager.createQuery("FROM HouseMeeting", HouseMeeting.class);
        return query.getResultList();
    }
}
