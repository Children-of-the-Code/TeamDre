package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {





    @Query("from User where username= :username and password= :password")
    User login(@Param("username")String username, @Param("password")String password);


    @Query("from User where username=:username")
    User getUserByUsername(@Param("username") String username);
    @Query("from User where email=:email")
    User getUserByEmail(@Param("email")String email);
}
