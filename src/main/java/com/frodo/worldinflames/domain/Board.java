package com.frodo.worldinflames.domain;

import java.util.List;

/**
 * Aggregate root
 */
public class Board {
    private final List<Tile> tiles;
    private final Unit unit; // the player's unit
    private final int goalX;
    private final int goalY;

    public Board(List<Tile> tiles, Unit unit, int goalX, int goalY) {
        this.tiles = tiles;
        this.unit = unit;
        this.goalX = goalX;
        this.goalY = goalY;
    }

    public Tile getTileAt(int x, int y) {
        return tiles.stream()
                .filter(t -> t.getX() == x && t.getY() == y)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No tile at position (" + x + "," + y + ")"));
    }

    public boolean isGameOver(Player player) {
        // Game over if health <= 0 or player reaches goal
        return player.getHealth() <= 0 || (player.getX() == goalX && player.getY() == goalY);
    }
}
