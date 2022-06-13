package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import com.TeamDre.AnimalAdoption.Model.Donation;

import com.TeamDre.AnimalAdoption.Repository.DonationRepository;
import com.TeamDre.AnimalAdoption.Repository.OrganizationRepository;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class DonationService {
    DonationRepository donationRepository;
    UserRepository userRepository;
    OrganizationRepository organizationRepository;

    @Autowired
    public DonationService(DonationRepository donationRep, UserRepository userRep, OrganizationRepository orgRep){
        this.donationRepository = donationRep;
        this.userRepository = userRep;
        this.organizationRepository = orgRep;
    }

    public List<Donation> getAllDonations(){ return donationRepository.findAll(); };

    public Donation getDonationById(int id){
        try{
            Donation donation = donationRepository.findById(id).get();
            return donation;
        }catch(NoSuchElementException e){
            System.out.println("Donation with the ID " + id + " not found.");
            return null;
        }
    }

    public void createDonation(double amount, int userId, int orgId){
        Donation donation = new Donation();

        donation.setAmount(amount);
        //String pattern = "";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date currentDate = new Date();
        donation.setDate_added(currentDate);
        donation.setUser(userRepository.getById(userId));
        donation.setOrganization((organizationRepository.getById(orgId)));

        donationRepository.save(donation);
    }
}
