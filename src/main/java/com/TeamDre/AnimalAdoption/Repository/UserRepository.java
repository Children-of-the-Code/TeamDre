package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User where username = :username")
    User findUserBYUsername(@Param("username") String username);




    @Query("from User where username= :username and password= :password")
    User login(@Param("username")String username, @Param("password")String password);
    @Query("from User where username=:username")
    User getUserByUsername(@Param("username") String username);
    @Query("from User where email=:email")
    User getUserByEmail(@Param("email")String email);
    @Query("from User where id= :id")
    User getUserById(@Param("id") int id);


    User findByUsername(String name);

}

