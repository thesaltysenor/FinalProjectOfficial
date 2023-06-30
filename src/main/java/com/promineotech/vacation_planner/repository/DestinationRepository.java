package com.promineotech.vacation_planner.repository;

import com.promineotech.vacation_planner.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
