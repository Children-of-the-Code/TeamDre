package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    @Query("from Organization where username= :username")
    Organization getOrganizationByUsername(@Param("username")String username);
    @Query("from Organization where email= :email")
    Organization getOrganizationByEmail(@Param("email")String email);
    @Query("from Organization where username= :username and password= :password")
    Organization login(@Param("username") String username,@Param("password") String password);
}
