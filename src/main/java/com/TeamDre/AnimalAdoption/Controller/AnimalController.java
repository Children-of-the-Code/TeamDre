package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Service.AnimalService;
import com.TeamDre.AnimalAdoption.Service.OrganizationService;
import com.TeamDre.AnimalAdoption.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("animals")
public class AnimalController {
    AnimalService animalService;
    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService=animalService;
    }
    @GetMapping("all")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimal();
    }
    @GetMapping("id/{id}")
    public Animal getAnimalById(@PathVariable int id){
        return animalService.getAnimalById(id);
    }
    @GetMapping("name/{name}")
    public List<Animal> getAnimalByName(@PathVariable String name){
        return animalService.getAnimalByName(name);
    }
    @GetMapping("gender/{gender}")
    public List<Animal> getAnimalByColor(@PathVariable Animal.Gender gender){
        return animalService.getAnimalByGender(gender);
    }
    @GetMapping("city/{city}")
    public List<Animal> getAnimalByCity(@PathVariable String city){
        return animalService.getAnimalByCity(city);
    }
    @GetMapping("state/{state}")
    public List<Animal> getAnimalByState(@PathVariable String state){
        return animalService.getAnimalByState(state);
    }
    @GetMapping("type/{type}")
    public List<Animal> getAnimalByType(@PathVariable String type){
        return animalService.getAnimalByType(type);
    }
    @GetMapping("breed/{breed}")
    public List<Animal> getAnimalByBreed(@PathVariable String breed){
        return animalService.getAnimalByBreed(breed);
    }
    @GetMapping("temperament/{temperament}")
    public List<Animal> getAnimalByTemperament(@PathVariable Animal.Temperament temperament){
        return animalService.getAnimalByTemperament(temperament);
    }
    @GetMapping("age/{age}")
    public List<Animal> getAnimalByAge(@PathVariable int age){
        return animalService.getAnimalByAge(age);
    }
    @GetMapping("fee/{fee}")
    public List<Animal> getAnimalByFee(@PathVariable int fee){
        return animalService.getAnimalByFee(fee);
    }
    @GetMapping("date/{date}")
    public Animal getAnimalByDateAdded(@PathVariable Date date){
        return animalService.getAnimalByDateAdded(date);
    }
    @GetMapping("organization/{organization}")
    public List<Animal> getAnimalByOrganization(@PathVariable Organization organization){
        return animalService.getAnimalByOrganization(organization);
    }
    @PostMapping("add/{id}")
    public void addAnimal(@RequestBody Animal animal, @PathVariable("id") int id){

        animalService.createAnimal(animal, id);
    }

    @GetMapping("parameters/{type}/{breed}")
    public List<Animal> getAnimalByDiffParameters(@PathVariable String type, @PathVariable String breed){
        return animalService.getAnimalByDiffParameters(type, breed);
    }

    @GetMapping("parameters/{type}/{breed}/{gender}")
    public List<Animal> getAnimalByDiffParameters(@PathVariable String type, @PathVariable String breed, @PathVariable Animal.Gender gender){
        return animalService.getAnimalByThreeParameters(type, breed, gender);
    }

    @GetMapping("parameters/{type}/{breed}/{gender}/{city}")
    public List<Animal> getAnimalByDiffParameters(@PathVariable String type, @PathVariable String breed, @PathVariable Animal.Gender gender, @PathVariable String city){
        return animalService.getAnimalByMostParameters(type, breed, gender, city);
    }

    @GetMapping("ages")
    public List<Animal> getAnimalByAgeIn(@RequestParam(value = "ages", required = false) Set<Integer> ages){
        return animalService.getAnimalByAgeIn(ages);
    }
}
