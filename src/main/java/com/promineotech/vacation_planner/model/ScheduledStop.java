package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ScheduledStop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduledStop ;

    // @ManyToOne is a JPA annotation that indicates a many to one relationship from ScheduledStop to Itinerary.
    // This means each ScheduledStop is associated with one Itinerary.
    // @JoinColumn is used to specify the mapped column for joining an entity association or element collection.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itinerary_id")
    private Itinerary itinerary;

    // @ManyToOne indicates a many to one relationship from ScheduledStop to Destination.
    // This means each ScheduledStop is associated with one Destination.
    // @JoinColumn indicates the column name for the Destination this stop is associated with.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_id")
    private Destination destination;

}
