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

    public String changePassword(int id, String s) {
        User user=userRepository.getUserById(id);
        if (user!=null&&!user.getPassword().equals(s)){
            user.setPassword(s);
            userRepository.save(user);
            return "Password changed successfully";
        }else {
            return "could not change password";
        }
    }

    public String changeUserInfo(User user) {
        User temp=userRepository.getUserById(user.getUser_id());
        User emailCheck=userRepository.getUserByEmail(user.getEmail());
        User usernameCheck=userRepository.getUserByUsername(user.getUsername());
        if (temp!=null){
            System.out.println("step1");
            if (usernameCheck!=null&&usernameCheck.getUser_id()!=temp.getUser_id()) {
                return "User info cannot be updated because username already exists!";
            }else if(emailCheck!=null&&emailCheck.getUser_id()!=temp.getUser_id()){
                return "User info cannot be updated because the Email already exists for an account. If you own this email, try changing the password.";
            }else if (temp.getUser_id()==user.getUser_id()){
                userRepository.save(user);
                return "User info successfully updated!";
            }
        }else{
            return "Could not update the user. Please fill out the form correctly";
        }
        return "unknown error";
    }

    public User getByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
