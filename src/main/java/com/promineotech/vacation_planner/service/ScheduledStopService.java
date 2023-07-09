package com.promineotech.vacation_planner.service;

import com.promineotech.vacation_planner.model.Destination;
import com.promineotech.vacation_planner.model.Itinerary;
import com.promineotech.vacation_planner.model.ScheduledStop;
import com.promineotech.vacation_planner.repository.ScheduledStopRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledStopService {

    private final ScheduledStopRepository scheduledStopRepository;
    private final ItineraryService itineraryService;
    private final DestinationService destinationService;

    @Autowired
    public ScheduledStopService(ScheduledStopRepository scheduledStopRepository,
                                ItineraryService itineraryService, DestinationService destinationService) {
        this.scheduledStopRepository = scheduledStopRepository;
        this.itineraryService = itineraryService;
        this.destinationService = destinationService;
    }

    public ScheduledStop getScheduledStopById(Long scheduledStop) {
        return scheduledStopRepository.findById(scheduledStop)
                .orElseThrow(() -> new IllegalArgumentException("Invalid itinerary destination Id:" + scheduledStop));
    }

    public List<ScheduledStop> getScheduledStopId() {
        return scheduledStopRepository.findAll();
    }

    public ScheduledStop saveScheduledStop(ScheduledStop scheduledStop) {
        Itinerary itinerary = itineraryService.getItineraryById(scheduledStop.getItinerary().getItineraryId());
        Destination destination = destinationService.getDestinationById(scheduledStop.getDestination().getDestinationId());

        if (itinerary == null || destination == null) {
            throw new IllegalArgumentException("Itinerary or Destination not found by given id");
        }

        return scheduledStopRepository.save(scheduledStop);

    }

    public ScheduledStop updateScheduledStop(Long id, ScheduledStop scheduledStopDetails) {
        ScheduledStop scheduledStop = getScheduledStopById(id);
        scheduledStop.setItinerary(scheduledStopDetails.getItinerary());
        scheduledStop.setDestination(scheduledStopDetails.getDestination());
        return scheduledStopRepository.save(scheduledStop);
    }


    public void deleteScheduledStop(Long scheduledStopId) {
       ScheduledStop scheduledStop = scheduledStopRepository.findById(scheduledStopId)
               .orElseThrow(() -> new EntityNotFoundException("Invalid itinerary destination Id:" + scheduledStopId));
       scheduledStopRepository.delete(scheduledStop);
    }

    public List<ScheduledStop> getScheduledStopsByItineraryId(Long itineraryId) {
        Itinerary itinerary = itineraryService.getItineraryById(itineraryId);

        if (itinerary == null) {
            throw new EntityNotFoundException("Itinerary with id " + itineraryId + " not found.");
        }

        return scheduledStopRepository.findAllByItinerary(itinerary);
    }

}
