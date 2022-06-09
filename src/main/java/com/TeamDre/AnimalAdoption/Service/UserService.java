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
        String username=user.getUsername();
        User temp=userRepository.getUserByUsername(username);
        User temp2=userRepository.getUserByEmail(user.getEmail());
        if (temp==null&&temp2==null) {
            userRepository.save(user);
        }
    }
    public User login(String username, String password){
        User user = userRepository.login(username, password);

        if (user!=null) {

             return user;
        }else {
            return null;
        }
    }

    public User getUserInformation(int id) {
        User user=userRepository.getUserById(id);
        if (user!=null){
            return user;
        }else{
            return null;
        }
    }
}
