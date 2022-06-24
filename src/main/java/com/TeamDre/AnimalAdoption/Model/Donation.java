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
public class Donation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donation_id;
    @Column
    private double amount;
    @Column
    private Date date_added;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
}
