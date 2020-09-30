package com.trendyol.toyrobot.domain.move;

import com.trendyol.toyrobot.domain.Compass;

public class MoveController {

    public Move getMove(Compass compass) {
        if (Compass.NORTH.equals(compass)) {
            return new NorthMove();
        } else if (Compass.SOUTH.equals(compass)) {
            return new SouthMove();
        } else if (Compass.EAST.equals(compass)) {
            return new EastMove();
        } else
            return new WestMove();
    }
}
