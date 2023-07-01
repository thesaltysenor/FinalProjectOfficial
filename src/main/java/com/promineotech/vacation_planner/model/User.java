package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Itinerary> itineraries;
}