package com.promineotech.vacation_planner.repository;

import com.promineotech.vacation_planner.model.Itinerary;
import com.promineotech.vacation_planner.model.ScheduledStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduledStopRepository extends JpaRepository<ScheduledStop, Long> {
    List<ScheduledStop> findAllByItinerary(Itinerary itinerary);

}
