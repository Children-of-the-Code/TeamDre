package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Service.AdoptedInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inquiries")
public class AdoptedInquiryController {
    AdoptedInquiryService adoptedInquiryService;

    @Autowired
    public AdoptedInquiryController (AdoptedInquiryService adoptedInquiryService){
        this.adoptedInquiryService = adoptedInquiryService;
    }

    @GetMapping
    public List<AdoptedInquiry> getAllInquiries(){
        return adoptedInquiryService.getAllInquiries();
    }

    // Submit a new inquiry provided the user ID and animal ID
    @PostMapping("submit/user/{userId}/animal/{animalId}")
    public void submitInquiry(@PathVariable("userId") int userId, @PathVariable("animalId") int animalId) {
        adoptedInquiryService.createInquiry(userId, animalId);
    }

    // Get a list of inquiries by the same user
    @GetMapping("user/{id}")
    public List<AdoptedInquiry> getInquiriesByUserId(@PathVariable("id") int userId){
        return adoptedInquiryService.getInquiriesByUserId(userId);
    }

    // Get a list of inquiries for the same animal
    @GetMapping("animal/{id}")
    public List<AdoptedInquiry> getInquiriesByAnimalId(@PathVariable("id") int animalId){
        return adoptedInquiryService.getInquiriesByAnimalId(animalId);
    }

    // Update the status of an inquiry to Approved
    @PutMapping("approve/{id}")
    public void updateInquiryStatusApproved(@PathVariable("id") int inquiryId){
        adoptedInquiryService.updateInquiryStatus(inquiryId, AdoptedInquiry.Status.Approved);
    }

    // Update the status of an inquiry to Denied
    @PutMapping("deny/{id}")
    public void updateInquiryStatusDenied(@PathVariable("id") int inquiryId){
        adoptedInquiryService.updateInquiryStatus(inquiryId, AdoptedInquiry.Status.Denied);
    }

    // Update the status of an inquiry to Canceled
    @PutMapping("cancel/{id}")
    public void updateInquiryStatusCancelled(@PathVariable("id") int inquiryId){
        adoptedInquiryService.updateInquiryStatus(inquiryId, AdoptedInquiry.Status.Cancelled);
    }

    @DeleteMapping("delete/{id}")
    public void deleteInquiryById(@PathVariable("id") int inquiryId){
        adoptedInquiryService.deleteInquiryById(inquiryId);
    }
}

//git commit -m "AdoptedInquiry CRUD endpoints functioning"
