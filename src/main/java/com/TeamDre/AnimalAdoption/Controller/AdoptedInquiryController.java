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

    @PostMapping("submit/user/{userId}/animal/{animalId}")
    public void submitInquiry(@RequestBody AdoptedInquiry inquiry, @PathVariable("userId") int userId, @PathVariable("animalId") int animalId){
        adoptedInquiryService.createInquiry(inquiry, userId, animalId);
    }
}
