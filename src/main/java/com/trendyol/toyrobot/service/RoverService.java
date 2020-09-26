package com.trendyol.toyrobot.service;

import com.trendyol.toyrobot.domain.Rover;
import com.trendyol.toyrobot.repository.RoverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoverService {

    private final RoverRepository roverRepository;

    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public void placeRover(Rover rover) {
        roverRepository.insert(rover);
    }

    public void turnRight(String id) {
        Rover rover = roverRepository.findById(id);
        rover.turnRight();
        roverRepository.update(rover);
    }

    public void turnLeft(String id) {
        Optional<Rover> optionalRover = roverRepository.findByIdOptional(id);
        if (optionalRover.isEmpty()) {
            return;
        }
        Rover rover = optionalRover.get();
        rover.turnLeft();
        roverRepository.update(rover);
    }

    public List<Rover> findAll() {
        return roverRepository.findAll();
    }

    public void move(String id) {
        Rover rover = roverRepository.findById(id);
        rover.move();
        roverRepository.update(rover);
    }

}
