package com.promineotech.vacation_planner.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ScheduledStop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduledStop ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itinerary_id")
    private Itinerary itinerary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_id")
    private Destination destination;

}
