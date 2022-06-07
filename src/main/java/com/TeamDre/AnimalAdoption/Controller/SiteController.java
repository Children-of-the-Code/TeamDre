package com.TeamDre.AnimalAdoption.Controller;
import com.TeamDre.AnimalAdoption.Model.*;
import com.TeamDre.AnimalAdoption.Service.AnimalService;
import com.TeamDre.AnimalAdoption.Service.OrganizationService;
import com.TeamDre.AnimalAdoption.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("animals")
public class SiteController {
    AnimalService animalService;
    OrganizationService organizationService;
    UserService userService;

    @Autowired
    public SiteController(AnimalService animalService, OrganizationService organizationService, UserService userService){
        this.animalService=animalService;
        this.organizationService=organizationService;
        this.userService=userService;
    }
    @GetMapping
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimal();
    }
    @PostMapping("add")
    public void addAnimal(@RequestBody Animal animal){
        animalService.createAnimal(animal);
    }

}
