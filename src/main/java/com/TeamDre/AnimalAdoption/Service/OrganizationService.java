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
        if (temp!=null&&temp2!=null) {
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
        if (org!=null){
            org.setPassword(s);
            organizationRepository.save(org);
            return "Password changed successfully";
        }else {
            return "could not change password";
        }
    }
}
