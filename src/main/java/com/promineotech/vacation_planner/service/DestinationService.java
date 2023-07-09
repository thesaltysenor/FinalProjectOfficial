package com.promineotech.vacation_planner.service;

import com.promineotech.vacation_planner.model.Destination;
import com.promineotech.vacation_planner.repository.DestinationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// The @Service annotation is a special type of @Component annotation which describes a class
// that's intended to hold business logic, calculations, database calls etc.
@Service
public class DestinationService {

    // This is dependency injection. The DestinationRepository object is injected into DestinationService
    // by the Spring framework.
    private final DestinationRepository destinationRepository;

    // @Autowired annotation is used by Spring to automatically inject the beans into the annotated field.
    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    // This method saves a Destination object in the database
    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    // This method updates a Destination object in the database.
    // If the destination doesn't exist, an EntityNotFoundException is thrown.
    public Destination updateDestination(Long destinationId, Destination updatedDestination) {
        return destinationRepository.findById(destinationId).map(destination -> {
            destination.setDestinationName(updatedDestination.getDestinationName());
            destination.setDestinationDescription(updatedDestination.getDestinationDescription());
            destination.setCity(updatedDestination.getCity());
            destination.setStateOrRegion(updatedDestination.getStateOrRegion());
            destination.setCountry(updatedDestination.getCountry());
            return destinationRepository.save(destination);
        }).orElseThrow(() -> new EntityNotFoundException("Destination with id " + destinationId + " not found."));
    }

    // This method returns a Destination by id from the database.
    // If the destination doesn't exist, an EntityNotFoundException is thrown.
    public Destination getDestinationById(Long destinationId) {
        return destinationRepository.findById(destinationId).orElseThrow(() -> new EntityNotFoundException("Destination with id " + destinationId + " not found."));
    }

    // This method returns all Destinations from the database.
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    // This method deletes a Destination by id from the database.
    // If the destination doesn't exist, an EntityNotFoundException is thrown.
    public void deleteDestination(Long destinationId) {
        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new EntityNotFoundException("Destination with id " + destinationId + "not found."));
        destinationRepository.delete(destination);
    }

}
