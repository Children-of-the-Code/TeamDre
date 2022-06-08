package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Service.AnimalService;
import com.TeamDre.AnimalAdoption.Service.OrganizationService;
import com.TeamDre.AnimalAdoption.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("animals")
public class AnimalController {
    AnimalService animalService;
    OrganizationService organizationService;
    UserService userService;



    @Autowired
    public AnimalController(AnimalService animalService/*, OrganizationService organizationService, UserService userService*/){
        this.animalService=animalService;
        //this.organizationService=organizationService;
        //this.userService=userService;
    }

    //Animal queries
    @GetMapping
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimal();
    }
    @PostMapping("add")
    public void addAnimal(@RequestBody Animal animal){
        animalService.createAnimal(animal);
    }

}
