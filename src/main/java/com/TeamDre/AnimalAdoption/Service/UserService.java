package com.TeamDre.AnimalAdoption.Service;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


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
    public User login(String username, String password){
            User user = userRepository.getByUsername(username, password);
        //System.out.println(username+" "+password);
            return null;
    }


}
