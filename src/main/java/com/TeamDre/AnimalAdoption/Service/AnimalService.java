package com.TeamDre.AnimalAdoption.Service;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
    public List<Animal> getAnimalByMostParameters(String type, String breed,  Animal.Gender gender, String city){
        return animalRepository.findAnimalByTypeAndBreedAndGenderAndOrganizationCity(type, breed, gender, city);
    }

    public List<Animal> getAnimalByDiffParameters(String type, String breed){
        return animalRepository.findAnimalByTypeAndBreed(type, breed);
    }
    public List<Animal> getAnimalByThreeParameters(String type, String breed, Animal.Gender gender){
        return animalRepository.findAnimalByTypeAndBreedAndGender(type, breed, gender);
    }

    public List<Animal> getAnimalByAgeIn(Set<Integer> ages){
        return animalRepository.findAnimalByAgeIn(ages);
    }

    public List<Animal> search(Map<String, Object> dto) {
        List<Animal> master = animalRepository.findAll();
        List<Animal> temp1 = new ArrayList<>();

        //age parameter
        if (!dto.get("age").toString().equals("0")){
            for(Animal a:master){
                if (a.getAge()==Integer.parseInt(dto.get("age").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }

        //gender parameter
        if (temp1.isEmpty()&&!dto.get("gender").toString().equals("")){
            for(Animal a:master){
                if (a.getGender().toString().equals(dto.get("gender").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }

        //temperament parameter
        if (!dto.get("temperament").toString().isEmpty()){

            for(Animal a:master){
                if (a.getTemperament().toString().equals(dto.get("temperament").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();

        }

        //organization parameter
        if (!dto.get("organization").toString().equals("0")){
            for(Animal a:master){
                if(a.getOrganization().getOrg_id()==Integer.parseInt(dto.get("organization").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }

        //city parameter
        if (!dto.get("city").toString().isEmpty()){
            for(Animal a:master){
                if(a.getOrganization().getCity().equals(dto.get("city").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }

        //state parameter

        if (!dto.get("state").toString().isEmpty()){
            for(Animal a:master){
                if(a.getOrganization().getState().equals(dto.get("state").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }


        return master;


    }
}
