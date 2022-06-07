package com.TeamDre.AnimalAdoption.Service;


import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalService {
    AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository=animalRepository;
    }

    public List<Animal> getAllAnimal(){
        return animalRepository.findAll();
    }
    public void createAnimal(Animal animal){
        animalRepository.save(animal);
    }
}
