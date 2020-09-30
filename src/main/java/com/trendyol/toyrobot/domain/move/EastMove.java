package com.trendyol.toyrobot.domain.move;

import com.trendyol.toyrobot.domain.Compass;

public class EastMove implements Move {
    private boolean isTurnLeft = false;
    @Override
    public int moveForwardX(int x) {
        return x+1;
    }

    @Override
    public int moveForwardY(int y) {
        return y;
    }

    @Override
    public Compass turnLeft() {
        isTurnLeft = true;
        return Compass.NORTH;
    }

    @Override
    public Compass turnRight() {
        return Compass.SOUTH;

    }

    @Override
    public Move newMove() {
        if (isTurnLeft)
            return new NorthMove();
        return new SouthMove();
    }
}
