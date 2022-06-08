package com.TeamDre.AnimalAdoption.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class AdoptedInquiry {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inquiry_id;
    @Column
    private Status status;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="animal_id", nullable = false)
    private Animal animal;

    public enum Status{
        Pending,
        Approved,
        Denied
    }

}
