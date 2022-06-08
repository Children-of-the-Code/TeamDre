package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizations")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
    public OrganizationController(OrganizationService organizationService){
        this.organizationService=organizationService;
    }

    @GetMapping()
    public List<Organization> getAllOrganization(){
        return organizationService.getAllOrganization();
    }
    @PostMapping("add")
    public void addOrganization(@RequestBody Organization organization){
        organizationService.createOrganization(organization);
    }
}
