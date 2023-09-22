package com.mc.House.dao;

import com.mc.House.dto.ApartmentSmall;
import com.mc.House.dto.HouseMeetingSmall;
import com.mc.House.entity.Apartment;
import com.mc.House.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApartmentDAOImpl implements ApartmentDAO {

    private final EntityManager entityManager;

    @Autowired
    public ApartmentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Apartment updateHouseMeeting(Apartment apartment) {
        entityManager.merge(apartment);
        return apartment;
    }

    @Override
    public List<ApartmentSmall> findAllSmall() {
        String queryString = "SELECT new com.mc.House.dto.ApartmentSmall(a.id, a.voteValue, a.branchAntenna, a.flor, a.address, a.street) FROM Apartment a";
        TypedQuery<ApartmentSmall> query = entityManager.createQuery(queryString, ApartmentSmall.class);
        List<ApartmentSmall> result = query.getResultList();
        return result.isEmpty() ? null : result;
    }


    @Override
    public Apartment findById(Integer id) {
        return entityManager.find(Apartment.class, id);
    }


}
