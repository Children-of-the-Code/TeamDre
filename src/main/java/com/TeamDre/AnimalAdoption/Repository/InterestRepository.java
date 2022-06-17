package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.Animal;
import com.TeamDre.AnimalAdoption.Model.Interest;
import com.TeamDre.AnimalAdoption.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface InterestRepository extends JpaRepository<Interest, Integer> {

    List<Interest> findAllByUser(User u);

    Interest findByUserAndAnimal(User u, Animal a);
}
