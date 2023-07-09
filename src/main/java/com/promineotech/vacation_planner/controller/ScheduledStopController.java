package com.promineotech.vacation_planner.controller;

import com.promineotech.vacation_planner.model.ScheduledStop;
import com.promineotech.vacation_planner.service.ScheduledStopService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduledstops")
public class ScheduledStopController {

    private final ScheduledStopService scheduledStopService;

    public ScheduledStopController(ScheduledStopService scheduledStopService)  {
        this.scheduledStopService = scheduledStopService;
    }

    @GetMapping
    public List<ScheduledStop> getAllScheduledStops() {
        return scheduledStopService.getScheduledStopId();
    }

    @GetMapping("/{id}")
    public ScheduledStop getScheduledStopById(@PathVariable Long id) {
        return scheduledStopService.getScheduledStopById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduledStop createScheduledStop (@RequestBody ScheduledStop scheduledStop) {
        return scheduledStopService.saveScheduledStop(scheduledStop);
    }

    @PutMapping("/{id}")
    public ScheduledStop updateScheduledStop(@PathVariable Long id, @RequestBody ScheduledStop scheduledStop) {
        return scheduledStopService.updateScheduledStop(id, scheduledStop);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduledStop(@PathVariable Long id) {
        scheduledStopService.deleteScheduledStop(id);
    }



}
