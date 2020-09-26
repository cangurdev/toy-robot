package com.trendyol.toyrobot.controller;

import com.trendyol.toyrobot.domain.Rover;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rovers")
public class RoverController {

    @PostMapping
    public ResponseEntity<Void> placeRover(Rover rover) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Rover>> listRovers() {
        return null;
    }

    @PostMapping("/{id}/turn-right")
    public ResponseEntity<Void> turnRight(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/turn-left")
    public ResponseEntity<Void> turnLeft(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/move")
    public ResponseEntity<Void> move(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}
