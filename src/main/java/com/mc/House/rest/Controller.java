package com.mc.House.rest;

import com.mc.House.entity.Apartment;
import com.mc.House.entity.Helpers.ApartmentMeetingInput;
import com.mc.House.entity.Helpers.UserAddHelper;
import com.mc.House.entity.Helpers.UserUpdateHelper;
import com.mc.House.rest.exceptions.DataNotFoundException;
import com.mc.House.entity.User;
import com.mc.House.service.ApartmentService;
import com.mc.House.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private UserService userService;
    private ApartmentService apartmentService;
    @Autowired
    public Controller(ApartmentService apartmentService, UserService userService){
        this.userService = userService;
        this.apartmentService = apartmentService;
    }

/*
    private List<User> userList;
    @PostConstruct //caled once after start to download new data
    public void loadData(){
        userList = userDAO.findAll();
    }
 */

    @GetMapping("/users/hello")
        public String hello(){
        return "hello user";
    }


    @GetMapping("/users/")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsersByID(@PathVariable int id){
        User user = userService.findById(id);
        //check id
        if (user==null)
            throw new DataNotFoundException("User not found "+id);
        return user;
    }


    @PostMapping("/users/")
    public User addUser(@RequestBody UserAddHelper userIn){
        return userService.save(userIn);
    }
    //{
    //    "username":"Ala",
    //    "email":"ala@s.z",
    //    "phone":125432,
    //    "owner":true,
    //    "apartment":2
    //}

    @PutMapping("/users/")
    public User updateUser(@RequestBody UserUpdateHelper userIn){
        return userService.update(userIn);
    }
    //{
    //    "id":"131"
    //    "username":"Ala",
    //    "email":"ala@s.z",
    //    "phone":125432,
    //    "owner":true,
    //    "apartment":2
    //}

    @DeleteMapping("/users/{id}")
    public User dellUser(@PathVariable int id){
        User user = userService.deleteById(id);
        //check id
        if (user==null)
            throw new DataNotFoundException("User not found "+id);
        return user;
    }


    @GetMapping("/apartments/")
    public List<Apartment> getApartments() {
        return apartmentService.findAll();
    }

    @PutMapping("/apartments/")
    public Apartment updateApartment(@RequestBody ApartmentMeetingInput apartmentMeetingInput){
        return apartmentService.addApartmentHouseMeeting(apartmentMeetingInput.getApartment(), apartmentMeetingInput.getHouseMeeting());
    }



    @GetMapping("/apartments/hello")
    public String hello2(){
        return "hello apartment";
    }
}
