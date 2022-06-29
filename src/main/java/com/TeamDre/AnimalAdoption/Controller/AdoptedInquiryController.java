package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Service.AdoptedInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins="*", allowedHeaders = "*")
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

    // Get a list of inquiries by status
    @GetMapping("status/{status}")
    public List<AdoptedInquiry> getPendingInquiries(@PathVariable("status") AdoptedInquiry.Status status){
        return adoptedInquiryService.getInquiriesByStatus(status);
    }

    // Update the status of an inquiry
    @PutMapping("status")
    public void updateInquiryStatusApproved(@RequestBody Map<String, Object> dto){
        adoptedInquiryService.updateInquiryStatus(Integer.parseInt(dto.get("inquiry_id").toString()), AdoptedInquiry.Status.valueOf(dto.get("status").toString()));
    }

    // Delete an inquiry by the ID
    @DeleteMapping("delete/{id}")
    public void deleteInquiryById(@PathVariable("id") int inquiryId){
        adoptedInquiryService.deleteInquiryById(inquiryId);
    }

    // Get list of inquired animals by user ID
    @GetMapping("animallist/{id}")
    public List<Animal> getallanimalsbyuserid(@PathVariable("id") int userId){
        return adoptedInquiryService.getAnimalsByUserId(userId);
    }

    // Get specific inquiry by user id and animal id
    @GetMapping("getinquiry/user/{userid}/animal/{animalid}")
    public AdoptedInquiry getInquiryByUserIdAndAnimalId(@PathVariable("userid") int userId, @PathVariable("animalid") int animalId){
        return adoptedInquiryService.getInquiryByUserIdAndAnimalId(userId , animalId);
    }

}
