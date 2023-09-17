package com.mc.House.dao;

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

    private EntityManager entityManager;

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
    public Apartment findById(Integer id) {
        return entityManager.find(Apartment.class, id);
    }

    @Override
    public List<Apartment> findAll() {
        TypedQuery<Apartment> query = entityManager.createQuery("FROM Apartment", Apartment.class);

        return query.getResultList();
    }


}
