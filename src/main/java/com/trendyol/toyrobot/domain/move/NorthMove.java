package com.trendyol.toyrobot.domain.move;

import com.trendyol.toyrobot.domain.Compass;

public class NorthMove implements Move {
    private boolean isTurnLeft = false;
    @Override
    public int moveForwardX(int x) {
        return x;
    }

    @Override
    public int moveForwardY(int y) {
        return y+1;
    }

    @Override
    public Compass turnLeft() {
        this.isTurnLeft = true;
        return Compass.WEST;
    }

    @Override
    public Compass turnRight() {
        return Compass.EAST;
    }

    @Override
    public Move newMove() {
        if (isTurnLeft)
            return new WestMove();
        return new EastMove();
    }

}
