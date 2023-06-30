package com.promineotech.vacation_planner.controller;

import com.promineotech.vacation_planner.model.Itinerary;
import com.promineotech.vacation_planner.service.ItineraryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping
    public List<Itinerary> getAllItineraries() {
        return itineraryService.getItineraries();
    }

    @GetMapping("/{id}")
    public Itinerary getItineraryById(@PathVariable Long id) {
        return itineraryService.getItineraryById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {
        return itineraryService.saveItinerary(itinerary);
    }

    @PutMapping("/{id}")
    public Itinerary updateItinerary(@PathVariable Long id, @RequestBody Itinerary itinerary) {
        return itineraryService.saveItinerary(itinerary);
    }

    @DeleteMapping("/{id}")
    public void deleteItinerary(@PathVariable Long id) {
        itineraryService.deleteItinerary(id);
    }
}
