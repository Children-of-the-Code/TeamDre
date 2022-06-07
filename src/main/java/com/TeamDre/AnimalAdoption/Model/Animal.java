package com.TeamDre.AnimalAdoption.Model;
import lombok.*;

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
    private Date date_added;
    @Column
    private String temperament;
    @Column
    private int fee;
    @Column
    private int org_id;
    @Column
    private String type;
    @Column
    private String breed;
    @Column
    private String gets_along;
}
