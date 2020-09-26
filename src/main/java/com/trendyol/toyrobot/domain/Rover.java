package com.trendyol.toyrobot.domain;

public class Rover {

    private int x;
    private int y;
    private Compass compass;

    public Rover() {
        this.x = 0;
        this.y = 0;
        this.compass = Compass.NORTH;
    }

    public Rover(int x, int y, Compass compass) {
        this.x = x;
        this.y = y;
        this.compass = compass;
    }

    public void move() {
        if (Compass.NORTH.equals(this.compass)) {
            this.y = this.y + 1;
        } else if (Compass.EAST.equals(this.compass)) {
            this.x = this.x + 1;
        } else if (Compass.SOUTH.equals(this.compass)) {
            this.y = this.y - 1;
        } else if (Compass.WEST.equals(this.compass)) {
            this.x = this.x - 1;
        }
    }

    public void turnLeft() {
        if (Compass.NORTH.equals(this.compass)) {
            this.compass = Compass.WEST;
        } else if (Compass.WEST.equals(this.compass)) {
            this.compass = Compass.SOUTH;
        } else if (Compass.SOUTH.equals(this.compass)) {
            this.compass = Compass.EAST;
        } else if (Compass.EAST.equals(this.compass)) {
            this.compass = Compass.NORTH;
        }
    }

    public void turnRight() {
        if (Compass.NORTH.equals(this.compass)) {
            this.compass = Compass.EAST;
        } else if (Compass.EAST.equals(this.compass)) {
            this.compass = Compass.SOUTH;
        } else if (Compass.SOUTH.equals(this.compass)) {
            this.compass = Compass.WEST;
        } else if (Compass.WEST.equals(this.compass)) {
            this.compass = Compass.NORTH;
        }
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
}
