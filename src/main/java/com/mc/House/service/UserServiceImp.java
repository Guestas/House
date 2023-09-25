package com.mc.House.service;

import com.mc.House.dao.ApartmentDAO;
import com.mc.House.dao.UserDAO;
import com.mc.House.dto.UserSmall;
import com.mc.House.entity.Apartment;
import com.mc.House.entity.Helpers.UserAddHelper;
import com.mc.House.entity.Helpers.UserUpdateHelper;
import com.mc.House.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{

    private final UserDAO userDAO;
    private final ApartmentDAO apartmentDAO;
    public UserServiceImp(UserDAO userDAO, ApartmentDAO apartmentDAO){
        this.userDAO = userDAO;
        this.apartmentDAO = apartmentDAO;
    }

    @Override
    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public List<UserSmall> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    @Transactional //every time i modify database it should be this
    public User save(UserAddHelper userAddHelper) {
        Apartment n = apartmentDAO.findById(userAddHelper.getApartment());
        User tempUser = userAddHelper.getUser();
        tempUser.setId(0);//set to 0 for add new item instead of update
        tempUser.setApartment(n);

        return userDAO.saveUpdate(tempUser);
    }

    @Override
    public List<User> findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    @Transactional //every time I modify database it should be this
    public User update(UserUpdateHelper userUpdateHelper) {
        Apartment n = apartmentDAO.findById(userUpdateHelper.getApartment());
        User tempUser = userUpdateHelper.getUser();
        tempUser.setApartment(n);
        return userDAO.saveUpdate(tempUser);
    }

    @Override
    @Transactional //every time i modify database it should be this
    public User deleteById(Integer id) {
        return userDAO.deleteById(id);
    }


}
