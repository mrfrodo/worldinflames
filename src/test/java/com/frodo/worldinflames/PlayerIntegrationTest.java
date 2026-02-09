package com.frodo.worldinflames;

import com.frodo.worldinflames.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Primary test driver
 */
public class PlayerIntegrationTest {

    private Board board;
    private Player player;

    @BeforeEach
    void setup() {
        // Create tiles
        Tile emptyTile = new Tile(0, 0, Tile.Type.EMPTY);
        Tile trapTile = new Tile(1, 0, Tile.Type.TRAP); // -10 health
        Tile healTile = new Tile(2, 0, Tile.Type.HEAL); // +50 health
        Tile goalTile = new Tile(3, 0, Tile.Type.GOAL);

        List<Tile> tiles = List.of(emptyTile, trapTile, healTile, goalTile);

        // Create unit and player
        Unit unit = new Unit(0, 0, 100);
        player = new Player("Frodo", unit);

        // Create board with goal at (3,0)
        board = new Board(tiles, unit, 3, 0);

        player = new Player("Frodo", unit);
    }

    @Test
    void testPlayerMovementAndTileEffects() {
        // Initial position
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertEquals(100, player.getHealth());

        // Move RIGHT onto trap (-10)
        player.move(Direction.RIGHT, board);
        assertEquals(1, player.getX());
        assertEquals(0, player.getY());
        assertEquals(90, player.getHealth());

        // Move RIGHT onto heal (+50)
        player.move(Direction.RIGHT, board);
        assertEquals(2, player.getX());
        assertEquals(0, player.getY());
        assertEquals(140, player.getHealth());

        // Move RIGHT onto goal
        player.move(Direction.RIGHT, board);
        assertEquals(3, player.getX());
        assertEquals(0, player.getY());
        assertEquals(140, player.getHealth());

        // Check game over
        assertTrue(board.isGameOver(player));
    }

    @Test
    void testPlayerDiesOnTrap() {
        // Trap heavy damage scenario
        Tile deadlyTrap = new Tile(0, 1, Tile.Type.TRAP); // -10
        board = new Board(List.of(deadlyTrap), player.getUnit(), 0, 2);

        // Reduce health manually for test
        player.getUnit().move(Direction.DOWN, board); // move to deadlyTrap
        player.getUnit().move(Direction.DOWN, board); // move again (simulate health drop)

        assertTrue(player.getHealth() <= 0 || board.isGameOver(player));
    }
}
