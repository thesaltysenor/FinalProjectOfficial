package com.promineotech.vacation_planner.service;

import com.promineotech.vacation_planner.model.ScheduledStop;
import com.promineotech.vacation_planner.repository.ScheduledStopRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledStopService {

    private final ScheduledStopRepository scheduledStopRepository;

    @Autowired
    public ScheduledStopService(ScheduledStopRepository scheduledStopRepository) {
        this.scheduledStopRepository = scheduledStopRepository;
    }

    public ScheduledStop getScheduledStopById(Long scheduledStop) {
        return scheduledStopRepository.findById(scheduledStop)
                .orElseThrow(() -> new IllegalArgumentException("Invalid itinerary destination Id:" + scheduledStop));
    }

    public List<ScheduledStop> getScheduledStopId() {
        return scheduledStopRepository.findAll();
    }

    public ScheduledStop saveScheduledStop(ScheduledStop scheduledStop) {
        return scheduledStopRepository.save(scheduledStop);
    }

    public void deleteScheduledStop(Long scheduledStopId) {
       ScheduledStop scheduledStop = scheduledStopRepository.findById(scheduledStopId)
               .orElseThrow(() -> new EntityNotFoundException("Invalid itinerary destination Id:" + scheduledStopId));
       scheduledStopRepository.delete(scheduledStop);
    }
}
