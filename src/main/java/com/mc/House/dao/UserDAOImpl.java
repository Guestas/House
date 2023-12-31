package com.mc.House.dao;

import com.mc.House.dto.UserSmall;
import com.mc.House.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public User saveUpdate(User user) {
        return entityManager.merge(user);
    }//merge is if empty create or update instead of persist
    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<UserSmall> findAllUsers() {
        String queryString = "SELECT new com.mc.House.dto.UserSmall(u.id, u.username, u.email, u.phone) FROM User u";
        TypedQuery<UserSmall> query = entityManager.createQuery(queryString, UserSmall.class);
        List<UserSmall> result = query.getResultList();
        return result.isEmpty() ? null : result;
    }

    @Override
    public User deleteById(Integer id) {
        User temp = entityManager.find(User.class, id);
        entityManager.remove(entityManager.find(User.class, id));
        return temp;
    }
    @Override
    public List<User> findByName(String name) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username=:theData", User.class);
        query.setParameter("theData", name);
        return query.getResultList();
    }

}
