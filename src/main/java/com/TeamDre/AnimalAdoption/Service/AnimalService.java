package com.TeamDre.AnimalAdoption.Service;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void createAnimal(Animal animal, int id){
        Organization u=organizationRepository.getById(id);
        animal.setOrganization(u);
        animalRepository.save(animal);
    }
}