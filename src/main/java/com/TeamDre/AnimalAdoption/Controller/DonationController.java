package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Donation;
import com.TeamDre.AnimalAdoption.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("submit")
    public void submitDonation(@RequestBody Map<String, Object> dto){
        donationService.createDonation(Double.parseDouble(dto.get("amount").toString()),
                Integer.parseInt(dto.get("user_id").toString()),
                Integer.parseInt(dto.get("org_id").toString()));
    }

}
