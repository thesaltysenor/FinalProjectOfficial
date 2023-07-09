package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long destinationId;

    @NotBlank(message = "Name cannot be blank.")
    private String destinationName;


    private String destinationDescription;

    @NotBlank(message = "City cannot be blank.")
    private String city;

    @NotBlank(message= "State or region cannot be blank.")
    private String stateOrRegion;

    @NotBlank(message = "Country cannot be blank.")
    private String country;


    @OneToMany(mappedBy = "destination")
    private Set<ScheduledStop> itineraries = new HashSet<>();

}
