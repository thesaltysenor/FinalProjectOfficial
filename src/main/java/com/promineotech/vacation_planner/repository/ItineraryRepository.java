package com.promineotech.vacation_planner.repository;

import com.promineotech.vacation_planner.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
}
