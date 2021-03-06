package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;

import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Donation;
import com.TeamDre.AnimalAdoption.Repository.AdoptedInquiryRepository;
import com.TeamDre.AnimalAdoption.Repository.AnimalRepository;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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

    public AdoptedInquiry getInquiryById(int id) {
        try{
            AdoptedInquiry adoptedInquiry = adoptedInquiryRepository.findById(id).get();
            return adoptedInquiry;
        }catch(NoSuchElementException e){
            System.out.println("Inquiry with the ID " + id + " not found.");
            return null;
        }
    }

    public List<AdoptedInquiry> getInquiriesByUserId (int userId) {
        return adoptedInquiryRepository.getInquiriesByUserID(userId);
    }

    public List<AdoptedInquiry> getInquiriesByAnimalId (int animalId) {
        return adoptedInquiryRepository.getInquiriesByAnimalId(animalId);
    }


    public List<AdoptedInquiry> getInquiriesByStatus (AdoptedInquiry.Status status){
        return adoptedInquiryRepository.getInquiriesByStatus(status);
    }

    public void createInquiry(int userId, int animalId){
        List<AdoptedInquiry> inquiries =new ArrayList<>();
        inquiries.addAll(adoptedInquiryRepository.getInquiriesByUserID(userId));
        AdoptedInquiry temp=new AdoptedInquiry();
        for(AdoptedInquiry a: inquiries){
            if(a.getAnimal().getAnimal_id() == animalId){
                temp=a;
            }
        }
        if (temp.getDate_added()==null) {
            AdoptedInquiry inquiry = new AdoptedInquiry();
            inquiry.setUser(userRepository.getById(userId));
            inquiry.setAnimal(animalRepository.getById(animalId));
            Date currentDate = new Date();
            inquiry.setDate_added(currentDate);
            inquiry.setStatus(AdoptedInquiry.Status.Pending);
            adoptedInquiryRepository.save(inquiry);
        }
    }

    public void deleteInquiryById(int inquiryId){
        try{
            AdoptedInquiry inquiry = adoptedInquiryRepository.getById(inquiryId);
            System.out.println(inquiry.toString());
            adoptedInquiryRepository.delete(inquiry);
            System.out.println("Success. Deleted inquiry with the ID " + inquiryId + ".");
        }catch(EntityNotFoundException e){
            System.out.println("Delete failed. Inquiry with the ID " + inquiryId + " does not exist.");
        }
    }

    public void updateInquiryStatus(int inquiryId, AdoptedInquiry.Status status ){
        try{
            AdoptedInquiry ai = adoptedInquiryRepository.getById(inquiryId);
            System.out.println(ai.toString());
            if(status != AdoptedInquiry.Status.Pending){
                if (status.equals(AdoptedInquiry.Status.Approved)){
                   Animal temp= animalRepository.getById(ai.getAnimal().getAnimal_id());
                   temp.setAdopted(true);
                   animalRepository.save(temp);
                }
                ai.setStatus(status);
                adoptedInquiryRepository.save(ai);
                System.out.println("Success. Updated inquiry with the status " + status + ".");
            } else {
                System.out.println("Update failed. Cannot set inquiry to pending once it has already been processed.");
            }
        }catch(EntityNotFoundException e){
            System.out.println("Update failed. Inquiry with the ID " + inquiryId + " does not exist.");
        }
    }

    public List<Animal> getAnimalsByUserId(int userId) {
        List<Animal> temp=new ArrayList<>();
        List<AdoptedInquiry> temp2=adoptedInquiryRepository.getInquiriesByUserID(userId);
        if (temp2!=null) {
            for (AdoptedInquiry a : temp2) {
                Animal b = animalRepository.getById(a.getAnimal().getAnimal_id());
                temp.add(b);
            }
            return temp;
        }
        return null;
    }
    public AdoptedInquiry getInquiryByUserIdAndAnimalId(int userId, int animalId){
        List<AdoptedInquiry> inquiries =new ArrayList<>();
        inquiries.addAll(adoptedInquiryRepository.getInquiriesByUserID(userId));
        for(AdoptedInquiry a: inquiries){
            if(a.getAnimal().getAnimal_id() == animalId){
                return a;
            }
        }
        return null;
    }
}
