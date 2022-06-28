package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins="*", allowedHeaders = "*")
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
    @PostMapping("add")
    public void addAnimal(@RequestBody Animal animal){
        animal.setAdopted(false);
        animalService.createAnimal(animal);
    }

    @GetMapping("findbyid/{id}")
    public Animal getAnimalById(@PathVariable("id") int id){
        return animalService.getAnimalById(id);
    }



    @PostMapping("search")
    public List<Animal> search(@RequestBody Map<String, Object> dto){
        return animalService.search(dto);
    }

    @PostMapping("sale/{id}")
    public Animal sale(@PathVariable("id") int id, @RequestBody Map<String, Object> dto){
        return animalService.addSale(id, dto);
    }

    @PostMapping("deleteanimal")
    public String deleteAnimal(@RequestBody Map<String, Object> dto){
        return animalService.deleteAnimal(Integer.parseInt(dto.get("animalid").toString()));
    }

    @PostMapping("changeanimal")
    public String changeAnimal(@RequestBody Animal animal){
        return animalService.changeInfo(animal);
    }

    @GetMapping("featured")
    public List<Animal> featured(){
        return animalService.getFeatured();
    }

}

