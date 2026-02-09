package com.frodo.worldinflames.infrastructure.out.file;

import com.frodo.worldinflames.domain.Tile;
import com.frodo.worldinflames.infrastructure.TileDTO;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Component
public class TileRepositoryJsonAdapter {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<TileDTO> loadBoard() {
        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("board-8x8.json")) {

            TileDTO[] tiles = mapper.readValue(is, TileDTO[].class);
            return List.of(tiles);

        } catch (Exception e) {
            throw new IllegalStateException("Cannot load board", e);
        }
    }
}
