package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters.")
    private String username;

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, message = "Password must contain at least eight characters.")
    private String password;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email should be valid.")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Itinerary> itineraries;
}