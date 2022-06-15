package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.Interest;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Repository.InterestRepository;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterestService {
    InterestRepository interestRepository;
    AnimalRepository animalRepository;
    UserRepository userRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository, AnimalRepository animalRepository, UserRepository userRepository){
        this.interestRepository = interestRepository;
        this.animalRepository = animalRepository;
        this.userRepository = userRepository;
    }

    public List<Animal> getAnimalsInterestedIn(int userID){
        List<Interest> allEntries = interestRepository.findAll();
        List<Interest> allowedEntrees = new ArrayList<>();
        for(Interest interest: allEntries){
            if(interest.getUser().getUser_id() == userID){
                allowedEntrees.add(interest);
            }
        }
        List<Animal> result = new ArrayList<>();
        for(Interest interest: allowedEntrees){
            result.add(interest.getAnimal());
        }
        return result;
    }

    public void favoriteAnimal(int userID, int animalID){
        Animal a = animalRepository.getById(animalID);
        User u = userRepository.getUserById(userID);
        Interest i = new Interest(u, a);
        interestRepository.save(i);
    }

    public void removeFavorite(int userID, int animalID){
        Animal a = animalRepository.getById(animalID);
        User u = userRepository.getUserById(userID);
        Interest i = new Interest(u, a);
        interestRepository.delete(i);
    }
}
