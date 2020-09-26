package com.trendyol.toyrobot.controller;

import com.trendyol.toyrobot.domain.Rover;
import com.trendyol.toyrobot.service.RoverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rovers")
public class RoverController {

    private final RoverService roverService;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    @PostMapping
    public ResponseEntity<Void> placeRover(@RequestBody Rover rover) {
        roverService.placeRover(rover);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Rover>> listRovers() {
        return ResponseEntity.ok(roverService.findAll());
    }

    @PostMapping("/{id}/turn-right")
    public ResponseEntity<Void> turnRight(@PathVariable String id) {
        roverService.turnRight(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/turn-left")
    public ResponseEntity<Void> turnLeft(@PathVariable String id) {
        roverService.turnLeft(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/move")
    public ResponseEntity<Void> move(@PathVariable String id) {
        roverService.move(id);
        return ResponseEntity.ok().build();
    }
}
