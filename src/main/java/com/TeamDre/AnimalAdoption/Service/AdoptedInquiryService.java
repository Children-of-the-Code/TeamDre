package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;

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

    public List<AdoptedInquiry> getInquiriesByOrgId (int orgId) {
        List<AdoptedInquiry> allInquiries = new ArrayList<AdoptedInquiry>();
        List<AdoptedInquiry> inquiriesWithOrgId = new ArrayList<AdoptedInquiry>();
        allInquiries = adoptedInquiryRepository.findAll();
        for(AdoptedInquiry a: allInquiries){
            if(a.getAnimal().getOrganization().getOrg_id() == orgId){
                inquiriesWithOrgId.add(a);
            }
        }
        return inquiriesWithOrgId;
        //return adoptedInquiryRepository.getInquiriesByOrgId(orgId);
    }

    public List<AdoptedInquiry> getInquiriesByStatus (AdoptedInquiry.Status status){
        return adoptedInquiryRepository.getInquiriesByStatus(status);
    }

    public void createInquiry(int userId, int animalId){
        AdoptedInquiry inquiry = new AdoptedInquiry();
        inquiry.setUser(userRepository.getById(userId));
        inquiry.setAnimal(animalRepository.getById(animalId));
        Date currentDate = new Date();
        inquiry.setDate_added(currentDate);
        inquiry.setStatus(AdoptedInquiry.Status.Pending);
        adoptedInquiryRepository.save(inquiry);
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
            ai.setStatus(status);
            adoptedInquiryRepository.save(ai);
            System.out.println("Success. Updated inquiry with the status " + status + ".");
        }catch(EntityNotFoundException e){
            System.out.println("Update failed. Inquiry with the ID " + inquiryId + " does not exist.");
        }
    }
}
