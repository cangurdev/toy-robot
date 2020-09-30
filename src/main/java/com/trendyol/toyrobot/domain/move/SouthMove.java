package com.trendyol.toyrobot.domain.move;

import com.trendyol.toyrobot.domain.Compass;

public class SouthMove implements Move {
    private boolean isTurnLeft = false;

    @Override
    public int moveForwardX(int x) {
        return x;
    }

    @Override
    public int moveForwardY(int y) {
        return y-1;
    }

    @Override
    public Compass turnLeft() {
        isTurnLeft = true;
        return Compass.EAST;
    }

    @Override
    public Compass turnRight() {
        return Compass.WEST;
    }

    @Override
    public Move newMove() {
        if (isTurnLeft)
            return new EastMove();
        return new WestMove();
    }
}
