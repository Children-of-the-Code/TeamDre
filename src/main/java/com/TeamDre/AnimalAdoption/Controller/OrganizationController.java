package com.TeamDre.AnimalAdoption.Controller;

import com.TeamDre.AnimalAdoption.Model.Organization;
import com.TeamDre.AnimalAdoption.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PostMapping("login")
    public Organization login(@RequestBody Map<String, Object> dto){
        return organizationService.login(dto.get("username").toString(), dto.get("password").toString());
    }
    @GetMapping("byid/{id}")
    public Organization byId(@PathVariable("id") int id){
        return organizationService.getOrganizationById(id);
    }
    @GetMapping("byname/{name}")
    public Organization byName(@PathVariable("name") String name){
        return organizationService.getOrganizationbyUsername(name);
    }
    @PostMapping("changepassword")
    public void changepassword(@RequestBody Map<String,Object> dto){
        organizationService.changePassword(Integer.parseInt(dto.get("id").toString()), dto.get("password").toString());
    }
}
