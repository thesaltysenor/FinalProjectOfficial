package com.promineotech.vacation_planner.repository;

import com.promineotech.vacation_planner.model.ScheduledStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledStopRepository extends JpaRepository<ScheduledStop, Long> {
}
