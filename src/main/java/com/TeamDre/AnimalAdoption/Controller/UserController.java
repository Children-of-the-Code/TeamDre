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
    public void createUser(@RequestBody User user){userService.createUser(user);}

    @GetMapping("{username}")
    public User getUserByUserName(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
    @PostMapping("login")
    public User loginUser(@RequestBody Map<String, Object> dto){
        return userService.login(dto.get("username").toString(),dto.get("password").toString());
    }

    @GetMapping("user/{id}")
    public User getUserInformation(@PathVariable("id") int id){
        return userService.getUserInformation(id);
    }

    @GetMapping("username/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userService.getByUsername(name);
    }

    @PostMapping("changepassword")
    public String changePassword(@RequestBody Map<String, Object> dto){
        return userService.changePassword(Integer.parseInt(dto.get("user_id").toString()), dto.get("password").toString());
    }

    @PostMapping("changeuserinfo")
    public String changeUserInfo(@RequestBody User user){
        return userService.changeUserInfo(user);
    }
}
