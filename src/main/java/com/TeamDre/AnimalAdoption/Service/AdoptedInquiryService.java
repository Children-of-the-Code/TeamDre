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

    public List<AdoptedInquiry> getAllInquiries() { return adoptedInquiryRepository.findAll(); }

    public List<AdoptedInquiry> getInquiriesByUserId (int userId) { return adoptedInquiryRepository.getInquiriesByUserID(userId); }

    public List<AdoptedInquiry> getInquiriesByAnimalId (int animalId) { return adoptedInquiryRepository.getInquiriesByAnimalId(animalId); }

    public void createInquiry(int userId, int animalId){
        AdoptedInquiry inquiry = new AdoptedInquiry();
        inquiry.setUser(userRepository.getById(userId));
        inquiry.setAnimal(animalRepository.getById(animalId));
        inquiry.setStatus(AdoptedInquiry.Status.Pending);
        adoptedInquiryRepository.save(inquiry);
    }

    public void deleteInquiryById(int inquiryId){
        //adoptedInquiryRepository.deleteById(inquiryId);
        AdoptedInquiry inquiry = adoptedInquiryRepository.getById(inquiryId);
        adoptedInquiryRepository.delete(inquiry);
    }

    public void updateInquiryStatus(int inquiryId, AdoptedInquiry.Status status ){
        AdoptedInquiry ai = adoptedInquiryRepository.getById(inquiryId);
        ai.setStatus(status);
        adoptedInquiryRepository.save(ai);
    }
}
