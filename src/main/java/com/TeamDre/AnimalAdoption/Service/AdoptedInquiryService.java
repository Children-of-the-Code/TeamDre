package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Repository.AdoptedInquiryRepository;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdoptedInquiryService {
    AdoptedInquiryRepository adoptedInquiryRepository;
    UserRepository userRepository;
    AnimalRepository animalRepository;

    @Autowired
    public AdoptedInquiryService(AdoptedInquiryRepository adoptedRep, UserRepository userRep, AnimalRepository animalRep){
        this.adoptedInquiryRepository = adoptedRep;
        this.userRepository = userRep;
        this.animalRepository = animalRep;
    }

    public List<AdoptedInquiry> getAllInquiries(){ return adoptedInquiryRepository.findAll(); }

    public void createInquiry(AdoptedInquiry inquiry, int userId, int animalId){
        inquiry.setUser(userRepository.getById(userId));
        inquiry.setAnimal(animalRepository.getById(animalId));
        adoptedInquiryRepository.save(inquiry);
    }
}
