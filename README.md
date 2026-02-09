# World in flames

2D board game for one player. Reach the end of the board without dying. Use arrow keys to move. 

Start the game at localhost:8080/worldinflames

Implemented in Java and thymeleaf. 

A hexagonal architecure ports and adapters design using domain driven design to model entities and aggreates.

ONE application use case WorldinflamesStartGameUseCase  

--- 

# Domain model
* One Board
* Tiles
* One Unit
* One Player
* 

## Aggregates/Entities:

### Board – Aggregate Root

* Owns Tiles and Unit

* Enforces game rules (movement, game over, goal detection)

### Tiles – Entity/value object

* Cannot exist without the board

* Has (x, y), type (TRAP, HEAL, GOAL), effect

### Unit – Entity

* Cannot exist without the board

* Moves around, has health

### Player – Aggregate

* Owns exactly one Unit (the avatar in the game)

* Represents the human player in the session

* Delegates movement and health access to the unit