package com.trendyol.toyrobot.domain.move;

import com.trendyol.toyrobot.domain.Compass;

public interface Move {
    int moveForwardX(int x);
    int moveForwardY(int y);
    Compass turnLeft();
    Compass turnRight();

    Move newMove();
}
