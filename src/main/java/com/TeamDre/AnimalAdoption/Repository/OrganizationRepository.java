package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    @Query("from Organization where username= :username")
    Organization getOrganizationByUsername(@Param("username")String username);
    @Query("from Organization where email= :email")
    Organization getOrganizationByEmail(@Param("email")String email);
    @Query("from Organization where username= :username and password= :password")
    Organization login(@Param("username") String username,@Param("password") String password);
    @Query("from Organization where org_id= :org_id")
    Organization findByOrg_id(@Param("org_id")int org_id);

    Organization findOrganizationByUsername(String name);
    @Query("from Organization where city= :city")
    List<Organization> findByCity(@Param("city") String city);
    @Query("from Organization where state= :state")
    List<Organization> findByState(@Param("state") String state);

}