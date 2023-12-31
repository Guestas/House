package com.mc.House.dao;

import com.mc.House.dto.UserSmall;
import com.mc.House.entity.User;

import java.util.List;

public interface UserDAO {
    User saveUpdate(User user);
    User findById(Integer id);
    List<UserSmall> findAllUsers();
    User deleteById(Integer id);
    List<User> findByName(String name);

}
