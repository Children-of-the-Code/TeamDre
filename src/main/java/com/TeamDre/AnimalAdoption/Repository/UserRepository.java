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





    /*@Query("from users where username= :username and password= :password")
    boolean login(String username, String password);*/

    @Query("FROM users WHERE username= :username AND password= :password")
    User getByUsername(@Param("username")String username, @Param("password")String password);
}
