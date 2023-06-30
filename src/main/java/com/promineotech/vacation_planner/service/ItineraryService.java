package com.promineotech.vacation_planner.service;

import com.promineotech.vacation_planner.model.Itinerary;
import com.promineotech.vacation_planner.repository.ItineraryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public Itinerary saveItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public Itinerary getItineraryById(Long itineraryId) {
        return itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new EntityNotFoundException("Itinerary with id " + itineraryId + " not found."));
    }

    public List<Itinerary> getItineraries() {
        return itineraryRepository.findAll();
    }

    public void deleteItinerary(Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new EntityNotFoundException("Itinerary with id " + itineraryId + " not found."));
        itineraryRepository.delete(itinerary);
    }
}
