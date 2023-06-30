package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itineraryId;

    private String itineraryName;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "itinerary")
    private Set<ScheduledStop> destinations = new HashSet<>();

}
