package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Interest;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Service.InterestService;
import com.TeamDre.AnimalAdoption.Service.AnimalService;
import com.TeamDre.AnimalAdoption.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("interests")
public class InterestController {
    InterestService interestService;
    UserService userService;

    @Autowired
    public InterestController(InterestService interestService, UserService userService) {
        this.interestService = interestService;
        this.userService = userService;
    }

    @GetMapping("user_id/{user_id}")
    public List<Animal> getFavoriteAnimals(@PathVariable("user_id")int id){
        return interestService.getAnimalsInterestedIn(id);
    }

    @PostMapping("favorite")
    public void addFavorite(@RequestBody int userId, int animalID){
        interestService.favoriteAnimal(userId, animalID);
    }

    @PostMapping("remove")
    public void removeFavorite(@RequestBody int userId, int animalId){
        interestService.removeFavorite(userId, animalId);
    }
}
