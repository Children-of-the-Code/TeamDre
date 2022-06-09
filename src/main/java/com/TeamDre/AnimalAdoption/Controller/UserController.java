package com.TeamDre.AnimalAdoption.Controller;


import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("add")
    public void addUser(@RequestBody User user){
        userService.createUser(user);
    }
    @PostMapping("login")
    public User loginUser(@RequestBody Map<String, Object> dto){
        return userService.login(dto.get("username").toString(),dto.get("password").toString());
        //System.out.println(dto.get("username").toString());
        //System.out.println(dto.get("password"));
        //.return null;
    }
    @GetMapping("user/{id}")
    public User getUserInformation(@PathVariable("id") int id){
        return userService.getUserInformation(id);
    }

}
