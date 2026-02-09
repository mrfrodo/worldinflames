package com.frodo.worldinflames.domain;

/**
 * Aggregate, cant exists without a game running
 */
public class Player {

    private final String name;
    private final Unit unit; // the avatar in the game

    public Player(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public void move(Direction direction, Board board) {
        unit.move(direction, board);
    }

    public String getName() { return name; }
    public Unit getUnit() {  return unit;  }
    public int getX() { return unit.getX(); }
    public int getY() { return unit.getY(); }
    public int getHealth() { return unit.getHealth(); }

}

