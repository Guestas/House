package com.mc.House.service;

import com.mc.House.dto.UserSmall;
import com.mc.House.entity.Helpers.UserAddHelper;
import com.mc.House.entity.Helpers.UserUpdateHelper;
import com.mc.House.entity.User;

import java.util.List;

public interface UserService {
    List<UserSmall> findAllUsers();
    User findById(Integer id);

    User save(UserAddHelper userAddHelper);

    List<User> findByName(String name);

    User update(UserUpdateHelper userUpdateHelper);

    User deleteById(Integer id);



}
