package com.TeamDre.AnimalAdoption.Controller;
import com.TeamDre.AnimalAdoption.Model.*;
import com.TeamDre.AnimalAdoption.Service.AnimalService;
import com.TeamDre.AnimalAdoption.Service.OrganizationService;
import com.TeamDre.AnimalAdoption.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("animals")
public class SiteController {
    Animal animal;
    Organization organization;
    User user;
    AnimalService animalService;
    OrganizationService organizationService;
    UserService userService;

    @Autowired
    public SiteController(AnimalService animalService, OrganizationService organizationService, UserService userService){
        this.animalService=animalService;
        this.organizationService=organizationService;
        this.userService=userService;
    }

}
