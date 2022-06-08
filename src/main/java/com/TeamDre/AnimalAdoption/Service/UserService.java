package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void createUser(User user){
        userRepository.save(user);
    }

}
