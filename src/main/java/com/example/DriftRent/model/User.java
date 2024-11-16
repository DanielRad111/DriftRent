package com.example.DriftRent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.*;

@Table(name = "`user`")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "findUserByEmail", query= "select a from User a where a.email = :email"),
                @NamedQuery(name = "findUserByRating", query= "select a from User a where a.rating = :rating")
        }
)
public class User {
    @Id
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private String password;
    @Column
    private Double rating;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Ad> ads;
}