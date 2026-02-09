package com.frodo.worldinflames.domain;

/**
 * Aggregate, cant exist without a board
 */
public class Tile {

    public enum Type { EMPTY, TRAP, HEAL, GOAL }

    private final int x;
    private final int y;
    private final Type type;
    private final int effectValue; // damage or heal

    public Tile(int x, int y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.effectValue = switch (type) {
            case TRAP -> -10;
            case HEAL -> 50;
            default -> 0;
        };
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Type getType() { return type; }
    public int getEffect() { return effectValue; }
}
