package com.TeamDre.AnimalAdoption.Model;


import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int user_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column(unique = true)
    private String email;
    @Column
    private String street_address;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private int zip;
    @Column
    private int phone;
    @Column(unique = true)
    private String username;
    @Column
    private String password;



}
