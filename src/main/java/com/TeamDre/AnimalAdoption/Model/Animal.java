package com.TeamDre.AnimalAdoption.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Animal implements Serializable {
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
    private int fee;

    @ManyToOne
    @JoinColumn(name="org_id", nullable = false)
    private Organization organization;
    @Column
    private String type;
    @Column
    private String breed;
    @Column
    private String gets_along;

    public enum Temperament{
        Mild,
        Medium,
        Hot,
        Spicy
    }
    public enum Gender{
        Male,
        Female
    }
}
