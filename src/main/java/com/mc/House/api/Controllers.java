package com.mc.House.api;

import com.mc.House.api.exceptions.DataNotFoundException;
import com.mc.House.dto.HouseMeetingSmall;
import com.mc.House.entity.Apartment;
import com.mc.House.entity.Helpers.ApartmentMeetingInput;
import com.mc.House.entity.Helpers.UserAddHelper;
import com.mc.House.entity.Helpers.UserUpdateHelper;
import com.mc.House.entity.HouseMeeting;
import com.mc.House.entity.User;
import com.mc.House.service.ApartmentService;
import com.mc.House.service.HouseMeetingService;
import com.mc.House.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //returning pages bur RestController returning only data
public class Controllers {
    //Load services
    private final UserService userService;
    private final ApartmentService apartmentService;
    private final HouseMeetingService houseMeetingService;
    @Autowired
    public Controllers(ApartmentService apartmentService, UserService userService, HouseMeetingService houseMeetingService){
        this.userService = userService;
        this.apartmentService = apartmentService;
        this.houseMeetingService = houseMeetingService;
    }

    //Created request's by type POST, PUT, GET and DEL this will communicate with Web browser or Postman ...
    @PostConstruct //caled once after start to download new data
    public void loadData(){
        System.out.println("Controller started!");
    }

    @GetMapping("/users/")
    public String getUserDetails(Model model) {
        model.addAttribute("allUserList", userService.findAllUsers());
        return "users";
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUsersByID(@PathVariable int id){
        User user = userService.findById(id);
        //check id
        if (user==null)
            throw new DataNotFoundException("User not found "+id);
        return user;
    }

    @GetMapping("/users/add")
    public String addUser(Model model){
        model.addAttribute("user", new UserAddHelper());
        return "newuser";
    }

    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute("user") UserAddHelper userIn){
        userService.save(userIn);
        return "redirect:/users/";
    }


    /*
    @ResponseBody
    public User addUser(@RequestBody UserAddHelper userIn){

        return userService.save(userIn);
    }*/
/* body in format:
    {
        "username":"Ala",
        "email":"ala@s.z",
        "phone":125432,
        "owner":true,
        "apartment":2
    }
*/

    @PutMapping("/users/")
    @ResponseBody
    public User updateUser(@RequestBody UserUpdateHelper userIn){
        User user = userService.findById(userIn.getUser().getId());
        if (user==null)
            throw new DataNotFoundException("User not found "+ userIn.getUser().getId());
        return userService.update(userIn);
    }
/* body in format:
    {
        "id":"131",
        "username":"Ala",
        "email":"ala@s.z",
        "phone":125432,
        "owner":true,
        "apartment":2
    }
*/

    @PostMapping("/users/{id}") // This method should handle POST requests
    @ResponseBody
    public User handleDeleteUserPost(@PathVariable int id) {
        // Logic to handle the simulated DELETE request
        return dellUser(id); // Call the delete method from here
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    public User dellUser(@PathVariable int id){
        User user = userService.deleteById(id);
        if (user==null)
            throw new DataNotFoundException("User not found "+id);
        return user;
    }




    @GetMapping("/apartments/")
    public String getApartmentsall(Model model) {
        model.addAttribute("allApartmentList", apartmentService.findAllSmall());
        return "apartments";
    }
    //@ResponseBody
    //public List<ApartmentSmall> getApartmentsall() {return apartmentService.findAllSmall();}


    @GetMapping("/apartments/{id}")
    @ResponseBody
    public Apartment getApartmentById(@PathVariable int id){
        if (id<0||id>126)
            throw new DataNotFoundException("Apartment ID out of bounds "+id);
        return apartmentService.findByApartmentId(id);
    }

    @PutMapping("/apartments/")
    @ResponseBody
    public Apartment updateApartment(@RequestBody ApartmentMeetingInput apartmentMeetingInput){
        return apartmentService.addApartmentHouseMeeting(apartmentMeetingInput.getApartment(), apartmentMeetingInput.getHouseMeeting());
    }
/* body in format:
    {
        "apartment":1,
        "houseMeeting":1
    }
*/


    @GetMapping("/houseMeetings/")
    @ResponseBody
    public List<HouseMeetingSmall> addHousemeetingsmall(){
        return houseMeetingService.findAllSmall();
    }

    @GetMapping("/houseMeetings/{id}")
    @ResponseBody
    public HouseMeeting getMeetingById(@PathVariable int id){
        return houseMeetingService.findById(id);
    }

    @PostMapping("/houseMeetings/")
    @ResponseBody
    public HouseMeeting addHousemeeting(@RequestBody HouseMeeting houseMeeting){
        return houseMeetingService.save(houseMeeting);
    }
/* body in format:
    {
        "date":"1.1.2001",
        "name":"Meeting name.",
        "topics":[
            "1. First topic. ",
            "2. Second topic. ",
            "3. Third topic. "
        ]
    }
*/
}
