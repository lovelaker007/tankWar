package com.laker.tank;

import java.awt.*;

public class Tank {

    private int x, y;
    private Direction direction;
    private int SPEED = 10;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void getPosByDirection(Direction direction){
        switch (direction){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void paint(Graphics g){
        getPosByDirection(direction);
        g.fillRect(x, y, 50, 50);
    }
}
