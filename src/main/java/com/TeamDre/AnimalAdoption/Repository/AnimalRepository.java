package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("FROM Animal where animal_id = :animal_id")
    Animal findAnimalById(@Param("animal_id") int animal_id);

}
