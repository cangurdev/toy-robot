package com.trendyol.toyrobot.domain.move;

import com.trendyol.toyrobot.domain.Compass;

public class WestMove implements Move {
    private boolean isTurnLeft = false;

    @Override
    public int moveForwardX(int x) {
        return x-1;
    }

    @Override
    public int moveForwardY(int y) {
        return y;
    }

    @Override
    public Compass turnLeft() {
        isTurnLeft = true;
        return Compass.SOUTH;
    }

    @Override
    public Compass turnRight() {
        return Compass.NORTH;
    }

    @Override
    public Move newMove() {
        if (isTurnLeft)
            return new SouthMove();
        return new NorthMove();
    }
}
