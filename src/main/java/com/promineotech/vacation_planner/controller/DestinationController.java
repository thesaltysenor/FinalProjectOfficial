package com.promineotech.vacation_planner.controller;

import com.promineotech.vacation_planner.model.Destination;
import com.promineotech.vacation_planner.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@Validated
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Destination createDestination(@RequestBody @Valid Destination destination) {
        return destinationService.saveDestination(destination);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable Long id, @RequestBody Destination updatedDestination) {
        return destinationService.updateDestination(id, updatedDestination);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
    }
}
