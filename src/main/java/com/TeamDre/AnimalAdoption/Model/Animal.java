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
    private Temperament temperament;
    @Column
    private int fee;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="org_id")
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
}
