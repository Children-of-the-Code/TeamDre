package com.TeamDre.AnimalAdoption.Service;
import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Model.User;
import com.TeamDre.AnimalAdoption.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationService {
    OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository=organizationRepository;
    }

    public List<Organization> getAllOrganization(){
        return organizationRepository.findAll();
    }
    public void createOrganization(Organization organization){
        Organization temp=organizationRepository.getOrganizationByUsername(organization.getUsername());
        Organization temp2=organizationRepository.getOrganizationByEmail(organization.getEmail());
        if (temp==null&&temp2==null) {
            organizationRepository.save(organization);
        }
    }

    public Organization login(String username, String password){
        Organization org=organizationRepository.login(username, password);
        if (org!=null){
            return org;
        }else{
            return null;
        }
    }

    public Organization getOrganizationById(int id) {
        return organizationRepository.findByOrg_id(id);
    }

    public Organization getOrganizationbyUsername(String name) {
        return organizationRepository.findOrganizationByUsername(name);
    }

    public String changePassword(int id, String s) {
        Organization org=organizationRepository.findByOrg_id(id);
        if (org!=null&&!org.getPassword().equals(s)){
            org.setPassword(s);
            organizationRepository.save(org);
            return "Password changed successfully";
        }else {
            return "could not change password";
        }
    }

    public String changeInfo(Organization org) {

            Organization temp=organizationRepository.getById(org.getOrg_id());
            Organization emailCheck=organizationRepository.getOrganizationByEmail(org.getEmail());
            Organization usernameCheck=organizationRepository.findOrganizationByUsername(org.getUsername());
            if (temp!=null){
                System.out.println("step1");
                if (usernameCheck!=null&&usernameCheck.getOrg_id()!=temp.getOrg_id()) {
                    return "Organization info cannot be updated because username already exists!";
                }else if(emailCheck!=null&&emailCheck.getOrg_id()!=temp.getOrg_id()){
                    return "Organization info cannot be updated because the Email already exists for an account. If you own this email, try changing the password.";
                }else if (temp.getOrg_id()==org.getOrg_id()){
                    organizationRepository.save(org);
                    return "Organization info successfully updated!";
                }
            }else{
                return "Could not update the Organization. Please fill out the form correctly";
            }
            return "unkown error";

    }
}
