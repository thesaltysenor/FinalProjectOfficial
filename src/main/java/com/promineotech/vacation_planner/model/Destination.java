package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long destinationId;

    private String destinationName;
    private String destinationDescription;
    private String city;
    private String stateOrRegion;
    private String country;


    @OneToMany(mappedBy = "destination")
    private Set<ScheduledStop> itineraries = new HashSet<>();


    public String getDestinationLocation() {
        return city + " , " + stateOrRegion + " , " + country;
    }

}
