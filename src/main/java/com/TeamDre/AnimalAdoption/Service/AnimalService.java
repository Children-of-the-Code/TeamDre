package com.TeamDre.AnimalAdoption.Service;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.*;

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
    public Animal getAnimalById(int id){
        return animalRepository.findAnimalById(id);
    }
    public List<Animal> getAnimalByName(String name){
        return animalRepository.findAnimalByName(name);
    }
    public List<Animal> getAnimalByType(Animal.Type type){
        return animalRepository.findAnimalByType(type);
    }
    public List<Animal> getAnimalByGender(Animal.Gender gender){
        return animalRepository.findAnimalByGender(gender);
    }
    public List<Animal> getAnimalByBreed(Animal.Breed breed){
        return animalRepository.findAnimalByBreed(breed);
    }
    public List<Animal> getAnimalByTemperament(Animal.Temperament temperament){
        return animalRepository.findAnimalByTemperament(temperament);
    }
    public List<Animal> getAnimalByAge(int age){
        return animalRepository.findAnimalByAge(age);
    }
    public List<Animal> getAnimalByFee(int fee){
        return animalRepository.findAnimalByFee(fee);
    }
    public Animal getAnimalByDateAdded(Date date){
        return animalRepository.findAnimalByDateAdded(date);
    }

    public void createAnimal(Animal animal){
        animalRepository.save(animal);
    }

    public String changeInfo(Animal animal) {

        Animal temp=animalRepository.findAnimalById(animal.getAnimal_id());
        System.out.println(temp);
        if (temp!=null){
           animalRepository.save(animal);
           return "animal changed";
        }else{
            return "Could not update the Animal. Please fill out the form correctly";
        }

    }
    public String deleteAnimal(int id){
        Animal temp= animalRepository.findAnimalById(id);

        if (temp!=null){
            animalRepository.delete(temp);
            return "deleted animal";
        }else{
            return "could not delete animal";
        }

    }


    public List<Animal> search(Map<String, Object> dto) {
        List<Animal> master = animalRepository.findAll();
        List<Animal> temp1 = new ArrayList<>();

        //type parameter
        if(!dto.get("type").toString().isEmpty()){
            for(Animal a:master){
                if (a.getType().toString().equals(dto.get("type").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }

        //breed parameter
        if (!dto.get("breed").toString().isEmpty()||!dto.get("breed2").toString().isEmpty()||!dto.get("breed3").toString().isEmpty()){
            if (!dto.get("breed").toString().isEmpty()){
                for (Animal a:master){
                    if (a.getBreed().toString().equals(dto.get("breed").toString())){
                        temp1.add(a);
                    }
                }
            }
            if (!dto.get("breed2").toString().isEmpty()){
                for (Animal a:master){
                    if (a.getBreed().toString().equals(dto.get("breed2").toString())){
                        temp1.add(a);
                    }
                }
            }
            if (!dto.get("breed3").toString().isEmpty()){
                for (Animal a:master){
                    if (a.getBreed().toString().equals(dto.get("breed3").toString())){
                        temp1.add(a);
                    }
                }
            }
            System.out.println(temp1);
            master=temp1;
            temp1=new ArrayList<>();
        }

        //age parameter
        if (!dto.get("age").toString().equals("0")||!dto.get("age2").toString().equals("0")||!dto.get("age").toString().isEmpty()||!dto.get("age2").toString().isEmpty()){
            int agemin=Integer.MIN_VALUE;
            int agemax=Integer.MAX_VALUE;
            if(!dto.get("age").toString().equals("0")&&!dto.get("age").toString().isEmpty()) {
                agemin = Integer.parseInt(dto.get("age").toString());
            }
            if(!dto.get("age2").toString().equals("0")&&!dto.get("age2").toString().isEmpty()) {
                agemax = Integer.parseInt(dto.get("age2").toString());
            }
            for(Animal a:master){
                if (a.getAge()>=agemin&&a.getAge()<=agemax){
                    temp1.add(a);
                    System.out.println(a);
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


        //fee parameter
        if (!dto.get("fee").toString().equals("0")||!dto.get("fee2").toString().equals("0")||!dto.get("fee").toString().isEmpty()||!dto.get("fee2").toString().isEmpty()){
            float feemin=Integer.MIN_VALUE;
            float feemax=Integer.MAX_VALUE;

            if(!dto.get("fee").toString().equals("0")&&!dto.get("fee").toString().isEmpty()) {
                feemin = Float.parseFloat(dto.get("fee").toString());
            }
            if(!dto.get("fee2").toString().equals("0")&&!dto.get("fee2").toString().isEmpty()) {
                feemax = Float.parseFloat(dto.get("fee2").toString());
            }
            for(Animal a:master){
                if (a.getFee()>=feemin&&a.getFee()<=feemax){
                    temp1.add(a);
                    System.out.println(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }

        //gets along parameter
        if (!dto.get("gets_along").toString().isEmpty()){
            for(Animal a:master){
                if(a.getGets_along().toString().equals(dto.get("gets_along").toString())){
                    temp1.add(a);
                }
            }
            master=temp1;
            temp1=new ArrayList<>();
        }



        //sort parameters
        if(dto.get("sortby").equals("name")) {
            Collections.sort(master, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if(dto.get("orderby").toString().isEmpty()) {
                        return o1.getName().compareTo((o2.getName()));
                    }else{
                        return o2.getName().compareTo((o1.getName()));
                    }
                }
            });
        }
        if(dto.get("sortby").equals("temperament")) {
            Collections.sort(master, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if(dto.get("orderby").toString().isEmpty()) {
                        return o1.getTemperament().compareTo((o2.getTemperament()));
                    }
                    else{
                        return o2.getTemperament().compareTo((o1.getTemperament()));
                    }
                }
            });
        }
        if(dto.get("sortby").equals("date")) {
            Collections.sort(master, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if(dto.get("orderby").toString().isEmpty()) {
                        return o1.getDate_added().compareTo((o2.getDate_added()));
                    }
                    else{
                        return o2.getDate_added().compareTo((o1.getDate_added()));
                    }
                }
            });
        }
        if(dto.get("sortby").equals("age")) {
            Collections.sort(master, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if(dto.get("orderby").toString().isEmpty()) {
                        return o1.getAge()-((o2.getAge()));
                    }
                    else{
                        return o2.getAge()-((o1.getAge()));
                    }
                }
            });
        }
        if(dto.get("sortby").equals("fee")) {
            Collections.sort(master, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if(dto.get("orderby").toString().isEmpty()) {
                        return Float.compare(o1.getFee(),o2.getFee());
                    }
                    else{
                        return Float.compare(o2.getFee(),o1.getFee());
                    }
                }
            });
        }
        if(dto.get("sortby").equals("breed")) {
            Collections.sort(master, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if(dto.get("orderby").toString().isEmpty()) {
                        return o1.getBreed().compareTo((o2.getBreed()));
                    }
                    else{
                        return o2.getBreed().compareTo((o1.getBreed()));
                    }
                }
            });
        }

        return master;
    }


    public Animal addSale(int id, Map<String, Object> dto) {
        final DecimalFormat df = new DecimalFormat("0.00");
        Animal animal=animalRepository.findById(id).get();
        float prevSale=(100-animal.getSale())/100;
        float newSale=(100-Float.parseFloat(dto.get("sale").toString()))/100;
        float reset=animal.getFee()/prevSale;
        animal.setFee(Float.parseFloat(df.format(reset*newSale)));
        animal.setSale(Float.parseFloat(dto.get("sale").toString()));
        animalRepository.save(animal);
        return animal;
    }
}

