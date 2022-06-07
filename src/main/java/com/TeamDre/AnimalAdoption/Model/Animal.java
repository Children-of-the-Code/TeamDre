package com.TeamDre.AnimalAdoption.Model;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
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
