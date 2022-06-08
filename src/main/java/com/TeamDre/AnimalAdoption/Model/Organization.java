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
public class Organization {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int org_id;
    @Column
    private String name;
    @Column
    private String street_address;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private int zip;
    @Column
    private long phone;
    @Column(unique = true, nullable = false)
    private String username;
    @Column
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column
    private String description;
}
