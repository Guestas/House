package com.mc.House.dao;

import com.mc.House.entity.User;

import java.util.List;

public interface UserDAO {
    void saveUpdate(User user);
    User findById(Integer id);
    List<User> findAll();
    User deleteById(Integer id);
    List<User> findByName(String name);
}
