package com.frodo.worldinflames.infrastructure;

/**
 * example
 [
 { "x": 0, "y": 0, "type": "EMPTY" },
 { "x": 1, "y": 0, "type": "TRAP" },
 { "x": 2, "y": 0, "type": "HEAL" },
 { "x": 3, "y": 0, "type": "GOAL" }
 ]
 */
public record TileDTO(int x, int y, String type) {
}