package com.promineotech.vacation_planner.service;

import com.promineotech.vacation_planner.model.Destination;
import com.promineotech.vacation_planner.repository.DestinationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Destination getDestinationById(Long destinationId) {
        return destinationRepository.findById(destinationId).orElseThrow(() -> new EntityNotFoundException("Destination with id " + destinationId + " not found."));
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public void deleteDestination(Long destinationId) {
        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new EntityNotFoundException("Destination with id " + destinationId + "not found."));
        destinationRepository.delete(destination);
    }

}
