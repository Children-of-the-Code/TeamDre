package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    public List<Animal> findAnimalByType(Animal.Type type);
    @Query("FROM Animal where animal_id = :animal_id")
    Animal findAnimalById(@Param("animal_id") int animal_id);
    public List<Animal> findAnimalByName(String name);
    public List<Animal> findAnimalByGender(Animal.Gender gender);
    public List<Animal> findAnimalByBreed(Animal.Breed breed);
    public List<Animal> findAnimalByAge(int age);
    public List<Animal> findAnimalByFee(int fee);
    @Query("FROM Animal where date_added = :date_added")
    Animal findAnimalByDateAdded(@Param("date_added") Date date_added);
    public List<Animal> findAnimalByTemperament(Animal.Temperament temperament);

    @Query("From Animal where adopted='false'")
    List<Animal> findAllAnimalByAdoption(boolean b);

    List<Animal> findByAgeGreaterThan(int s);
}



