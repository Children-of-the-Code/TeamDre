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
import java.util.Map;

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

    @GetMapping("get_all/{user_id}")
    public List<Animal> getFavoriteAnimals(@PathVariable("user_id")int id){
        return interestService.getAnimalsInterestedIn(id);
    }

    @PostMapping("favorite")
    public void addFavorite(@RequestBody Map<String, Object> dto){
        interestService.favoriteAnimal(Integer.parseInt(dto.get("userid").toString()), Integer.parseInt(dto.get("animalid").toString()));
    }

    @PostMapping("remove")
    public void removeFavorite(@RequestBody Map<String, Object> dto){
        interestService.removeFavorite(Integer.parseInt(dto.get("userid").toString()), Integer.parseInt(dto.get("animalid").toString()));
    }

}
