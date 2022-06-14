package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import com.TeamDre.AnimalAdoption.Service.AdoptedInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // Get Inquiry by ID
    @GetMapping("id/{id}")
    public AdoptedInquiry getInquiryById(@PathVariable("id") int id){
        return adoptedInquiryService.getInquiryById(id);
    }

    // Submit a new inquiry provided the user ID and animal ID in a JSON
    @PostMapping("submit")
    public void submitInquiry(@RequestBody Map<String, Object> dto) {
        adoptedInquiryService.createInquiry(Integer.parseInt(dto.get("user_id").toString()),Integer.parseInt(dto.get("animal_id").toString()));
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

    // Get inquiry by organization
    @GetMapping("organization/{id}")
    public List<AdoptedInquiry> getInquiriesByOrgId(@PathVariable("id") int orgId){
        return adoptedInquiryService.getInquiriesByOrgId(orgId);
    }

    // Get a list of pending inquiries
    @GetMapping("pending")
    public List<AdoptedInquiry> getPendingInquiries(){
        return adoptedInquiryService.getInquiriesByStatus(AdoptedInquiry.Status.Pending);
    }

    // Get a list of denied inquiries
    @GetMapping("denied")
    public List<AdoptedInquiry> getDeniedInquiries(){
        return adoptedInquiryService.getInquiriesByStatus(AdoptedInquiry.Status.Denied);
    }

    // Get a list of approved inquiries
    @GetMapping("approved")
    public List<AdoptedInquiry> getApprovedInquiries(){
        return adoptedInquiryService.getInquiriesByStatus(AdoptedInquiry.Status.Approved);
    }

    // Get a list of canceled inquiries
    @GetMapping("cancelled")
    public List<AdoptedInquiry> getCancelledInquiries(){
        return adoptedInquiryService.getInquiriesByStatus(AdoptedInquiry.Status.Cancelled);
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

    // Delete an inquiry by the ID
    @DeleteMapping("delete/{id}")
    public void deleteInquiryById(@PathVariable("id") int inquiryId){
        adoptedInquiryService.deleteInquiryById(inquiryId);
    }
}
