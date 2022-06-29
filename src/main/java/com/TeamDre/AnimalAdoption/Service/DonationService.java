package com.TeamDre.AnimalAdoption.Service;

import com.TeamDre.AnimalAdoption.Model.Donation;

import com.TeamDre.AnimalAdoption.Repository.DonationRepository;
import com.TeamDre.AnimalAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class DonationService {
    DonationRepository donationRepository;
    UserRepository userRepository;

    @Autowired
    public DonationService(DonationRepository donationRep, UserRepository userRep){
        this.donationRepository = donationRep;
        this.userRepository = userRep;
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

    public List<Donation> getDonationsByUserId(int userId){
        return donationRepository.getDonationsByUserId(userId);
    }

    public List<Donation> getDonationsByOrgId(int orgId){
        return donationRepository.getDonationsByOrgId(orgId);
    }

    public double getTotalAmountDonatedToOrg(int orgId){
        double result = 0;
        List<Donation> donations = new ArrayList<Donation>();
        donations.addAll(donationRepository.getDonationsByOrgId(orgId));
        for(Donation d: donations){
            result += d.getAmount();
        }
        return result;
    }

    public void createDonation(double amount, int userId){
        Donation donation = new Donation();

        donation.setAmount(amount);
        Date currentDate = new Date();
        donation.setDate_added(currentDate);
        donation.setUser(userRepository.getById(userId));

        donationRepository.save(donation);
    }
}
