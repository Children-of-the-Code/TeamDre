package com.TeamDre.AnimalAdoption.Service;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class AnimalService {
    AnimalRepository animalRepository;
    OrganizationRepository organizationRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository, OrganizationRepository organizationRepository){
        this.organizationRepository=organizationRepository;
        this.animalRepository=animalRepository;
    }

    public List<Animal> getAllAnimal(){
        return animalRepository.findAll();
    }
    public Animal getAnimalById(int id){
        return animalRepository.findAnimalById(id);
    }
    public List<Animal> getAnimalByName(String name){
        return animalRepository.findAnimalByName(name);
    }
    public List<Animal> getAnimalByType(String type){
        return animalRepository.findAnimalByType(type);
    }
    public List<Animal> getAnimalByColor(String color){
        return animalRepository.findAnimalByColor(color);
    }
    public List<Animal> getAnimalByGender(Animal.Gender gender){
        return animalRepository.findAnimalByGender(gender);
    }
    public List<Animal> getAnimalByBreed(String breed){
        return animalRepository.findAnimalByBreed(breed);
    }
    public List<Animal> getAnimalByTemperament(Animal.Temperament temperament){
        return animalRepository.findAnimalByTemperament(temperament);
    }
    public List<Animal> getAnimalByAge(int age){
        return animalRepository.findAnimalByAge(age);
    }
    public List<Animal> getAnimalByOrganization(Organization organization){
        return animalRepository.findAnimalByOrganization(organization);
    }
    public List<Animal> getAnimalByFee(int fee){
        return animalRepository.findAnimalByFee(fee);
    }
    public Animal getAnimalByDateAdded(Date date){
        return animalRepository.findAnimalByDateAdded(date);
    }
    public List<Animal> getAnimalByCity(String city){
        return animalRepository.findAnimalByOrganizationCity(city);
    }
    public List<Animal> getAnimalByState(String state){
        return animalRepository.findAnimalByOrganizationState(state);
    }
    public void createAnimal(Animal animal, int id){
        Organization u=organizationRepository.getById(id);
        animal.setOrganization(u);
        animalRepository.save(animal);
    }
}
