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




    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService=animalService;

    }

    //Animal queries
    @GetMapping
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimal();
    }
    @PostMapping("add/{id}")
    public void addAnimal(@RequestBody Animal animal, @PathVariable("id") int id){

        animalService.createAnimal(animal, id);
    }


    @PostMapping("search")
    public List<Animal> search(@RequestBody Map<String, Object> dto){
        return animalService.search(dto);
    }

    @PostMapping("sale/{id}")
    public List<Animal> sale(@PathVariable("id") int id, @RequestBody Map<String, Object> dto){
        return animalService.addSale(id, dto);
    }

    @PostMapping("deleteanimal")
    public String deleteAnimal(@RequestBody Map<String, Object> dto){
        return animalService.deleteAnimal(Integer.parseInt(dto.get("animalid").toString()), Integer.parseInt(dto.get("orgid").toString()));
    }

    @PostMapping("changeanimal")
    public String changeAnimal(@RequestBody Animal animal){
        return animalService.changeInfo(animal);
    }

}

