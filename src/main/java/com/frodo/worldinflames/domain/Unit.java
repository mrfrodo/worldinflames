package com.frodo.worldinflames.domain;

/**
 * Aggregate, cant exist without a Tile. All units belong to a one
 */
public class Unit {

    private int x;
    private int y;
    private int health;

    public Unit(int startX, int startY, int health) {
        this.x = startX;
        this.y = startY;
        this.health = health;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getHealth() { return health; }

    public void move(Direction direction, Board board) {
        int newX = x;
        int newY = y;

        switch(direction) {
            case UP -> newY--;
            case DOWN -> newY++;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        Tile tile = board.getTileAt(newX, newY);
        this.x = newX;
        this.y = newY;
        this.health += tile.getEffect(); // apply trap/heal effects
    }
}
