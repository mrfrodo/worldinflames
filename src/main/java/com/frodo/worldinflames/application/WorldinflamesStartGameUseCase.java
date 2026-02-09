package com.frodo.worldinflames.application;

import com.frodo.worldinflames.infrastructure.TileDTO;
import com.frodo.worldinflames.infrastructure.out.file.TileRepositoryJsonAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldinflamesStartGameUseCase {

    private final TileRepositoryJsonAdapter repo;

    public WorldinflamesStartGameUseCase(TileRepositoryJsonAdapter repo) {
        this.repo = repo;
    }

    public List<TileDTO> start() {
        return repo.loadBoard();
    }
}
