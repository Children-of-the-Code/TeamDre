package com.TeamDre.AnimalAdoption.Repository;
import com.TeamDre.AnimalAdoption.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

}
