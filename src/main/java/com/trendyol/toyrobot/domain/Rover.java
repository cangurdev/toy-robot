package com.trendyol.toyrobot.domain;

import com.trendyol.toyrobot.domain.move.Move;
import com.trendyol.toyrobot.domain.move.MoveController;
import com.trendyol.toyrobot.domain.move.NorthMove;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Rover {

    private String id;
    private int x;
    private int y;
    private Compass compass;
    private List<Material> material;
    private Move move;
    MoveController moveController = new MoveController();

    public Rover() {
        this.id = UUID.randomUUID().toString();
        this.x = 0;
        this.y = 0;
        this.compass = Compass.NORTH;
        this.material = Arrays.asList(new Material("Ramazan"));
        this.move = new NorthMove();
    }

    public Rover(int x, int y, Compass compass) {
        this.id = UUID.randomUUID().toString();
        this.x = x;
        this.y = y;
        this.compass = compass;
        this.material = Arrays.asList(new Material("Muhammed"));
        this.move = moveController.getMove(this.compass);
    }

    public void move() {
        this.x = move.moveForwardX(this.x);
        this.y = move.moveForwardY(this.y);
        //this.material.add(new Material(this.compass.name()));
    }

    public void turnLeft() {
        this.compass = move.turnLeft();
        this.move = move.newMove();
        //this.material.add(new Material(this.compass.name()));
    }

    public void turnRight() {
        this.compass = move.turnRight();
        this.move = move.newMove();
        //this.material.add(new Material(this.compass.name()));
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Compass getCompass() {
        return this.compass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }
}
