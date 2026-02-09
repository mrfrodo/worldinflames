package com.frodo.worldinflames;

import com.frodo.worldinflames.infrastructure.TileDTO;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TileDtoFileTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReadBoardFromJsonFile() throws Exception {
        // load from classpath
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("board-8x8.json");

        assertNotNull(is, "board-8x8.json not found on classpath");

        // map JSON -> DTOs
        TileDTO[] tiles = objectMapper.readValue(is, TileDTO[].class);

        // basic assertions
        assertEquals(64, tiles.length, "Board must have 64 tiles");

        // check corners
        TileDTO start = find(tiles, 0, 0);
        TileDTO goal  = find(tiles, 7, 7);

        assertEquals("EMPTY", start.type());
        assertEquals("GOAL", goal.type());
    }

    private TileDTO find(TileDTO[] tiles, int x, int y) {
        return List.of(tiles).stream()
                .filter(t -> t.x() == x && t.y() == y)
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("Tile not found at " + x + "," + y));
    }
}
