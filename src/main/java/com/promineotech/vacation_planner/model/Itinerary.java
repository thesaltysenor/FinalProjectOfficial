package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itineraryId;

    @NotBlank(message = "Itinerary must have a name.")
    private String itineraryName;

    // @Future annotation is used to ensure that the startDate is a date in the future.
    @NotNull
    @Column(nullable = false)
    @Future(message = "Start date must be in the future.")
    private LocalDate startDate;

    @NotNull
    @Column(nullable = false)
    @Future(message = "End date must be in the future.")
    private LocalDate endDate;

    // This means each Itinerary is associated with one User.
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // This means one Itinerary can have multiple ScheduledStops.
    // The HashSet will store these ScheduledStop instances.
    @OneToMany(mappedBy = "itinerary")
    private Set<ScheduledStop> destinations = new HashSet<>();

}
