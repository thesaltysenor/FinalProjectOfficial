package com.promineotech.vacation_planner.controller;

import com.promineotech.vacation_planner.model.Itinerary;
import com.promineotech.vacation_planner.model.ScheduledStop;
import com.promineotech.vacation_planner.service.ItineraryService;
import com.promineotech.vacation_planner.service.ScheduledStopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itineraries")
@Validated
public class ItineraryController {

    private final ItineraryService itineraryService;
    private final ScheduledStopService scheduledStopService;


    public ItineraryController(ItineraryService itineraryService, ScheduledStopService scheduledStopService) {
        this.itineraryService = itineraryService;
        this.scheduledStopService = scheduledStopService;
    }
    @GetMapping
    public List<Itinerary> getAllItineraries() {
        return itineraryService.getItineraries();
    }

    @GetMapping("/{id}")
    public Itinerary getItineraryById(@PathVariable Long id) {
        return itineraryService.getItineraryById(id);
    }

    @GetMapping("/{itineraryId}/stops")
    public List<ScheduledStop> getScheduledStopsByItinerary(@PathVariable Long itineraryId) {
        return scheduledStopService.getScheduledStopsByItineraryId(itineraryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Itinerary createItinerary(@RequestBody @Valid Itinerary itinerary) {
        return itineraryService.saveItinerary(itinerary);
    }

    @PutMapping("/{id}")
    public Itinerary updateItinerary(@PathVariable Long id, @RequestBody Itinerary updatedItinerary) {
        return itineraryService.updateItinerary(id, updatedItinerary);
    }

    @DeleteMapping("/{id}")
    public void deleteItinerary(@PathVariable Long id) {
        itineraryService.deleteItinerary(id);
    }
}
