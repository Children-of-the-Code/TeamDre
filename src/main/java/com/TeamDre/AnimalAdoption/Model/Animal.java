package com.TeamDre.AnimalAdoption.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Animal {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animal_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int age;
    @Column
    private Gender gender;
    @Column
    private Date date_added;
    @Column
    private Temperament temperament;
    @Column
    private float fee;
    @Column
    private Type type;
    @Column
    private Breed breed;
    @Column
    private GetsAlong gets_along;
    @Column
    private String url;
    @Column
    private float sale;
    @Column
    private boolean adopted;

    public enum Type{
        Dog,
        Cat
    }
    public enum Temperament{
        Mild,
        Medium,
        Hot,
        Spicy
    }
    public enum Gender{
        Male,
        Female,
        Unknown
    }
    public enum GetsAlong{
        Dogs,
        Cats,
        kids,
        AllAnimals,
        AllAnimalKids,
        None
    }
    public enum Breed{
        Abyssinian,
        Aussiedoodle,
        Beagle,
        Bombay,
        Bulldog,
        Calico,
        Chihuahua,
        Dalmatian,
        Feist,
        Greyhound,
        Havana,
        Hound,
        Husky,
        Jindo,
        Labrador,
        Manx,
        Mastiff,
        Mix,
        Persian,
        Ocicat,
        Other,
        Ragdoll,
        Rottweiler,
        Shepherd,
        Siamese,
        Sphynx,
        Tabby,
        Tuxedo
    }
}

