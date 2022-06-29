package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Donation;
import com.TeamDre.AnimalAdoption.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("donations")
public class DonationController {
    DonationService donationService;

    @Autowired
    public DonationController (DonationService donationService){
        this.donationService = donationService;
    }

    @GetMapping
    public List<Donation> getAllDonations(){
        return donationService.getAllDonations();
    }

    // Get transaction by ID
    @GetMapping("id/{id}")
    public Donation getDonationById(@PathVariable("id") int id){
        return donationService.getDonationById(id);
    }

    // List transactions by User
    @GetMapping("user/{id}")
    public List<Donation> getInquiriesByUserId(@PathVariable("id") int userId){
        return donationService.getDonationsByUserId(userId);
    }

    // List donations to a certain organization
    @GetMapping("organization/{id}")
    public List<Donation> getInquiriesByOrgId(@PathVariable("id") int orgId){
        return donationService.getDonationsByOrgId(orgId);
    }

    // Get total amount donated to an organization
    @GetMapping("total/organization/{id}")
    public double getTotalAmountDonatedToOrg(@PathVariable("id") int orgId){
        return donationService.getTotalAmountDonatedToOrg(orgId);
    }

    // Submit a new donation provided amount, user ID, and organization ID in a JSON
    @PostMapping("submit")
    public void submitDonation(@RequestBody Map<String, Object> dto){
        donationService.createDonation(Double.parseDouble(dto.get("amount").toString()),
                Integer.parseInt(dto.get("user_id").toString()));
    }

}
