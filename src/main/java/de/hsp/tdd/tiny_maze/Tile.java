package de.hsp.tdd.tiny_maze;

import java.util.*;

final class Tile {
  private final TileType symbol;
  private Tile predecessor;

  private boolean visited;
  private boolean partOfSolution;

  Tile(String symbol) {
    this.symbol = TileType.of(symbol).orElse(null);
  }

  public boolean isVisited() {
    return visited;
  }

  public boolean needsVisit() {
    // We do not need to check walls, so they count as "visited"
    return symbol != TileType.WALL
        && !visited;
  }

  public boolean isPotentialNextStep() {
    return symbol == TileType.END
        || symbol == TileType.FREE && !visited;
  }

  public boolean isStart() {
    return symbol == TileType.START;
  }

  public boolean isEnd() {
    return symbol == TileType.END;
  }

  public void markAsVisited(Tile predecessor) {
    this.predecessor = predecessor;
    this.visited = true;
  }

  public void markSolution() {
    Tile currentTile = this;
    while (currentTile != null) {
      currentTile.partOfSolution = true;
      currentTile = currentTile.predecessor;
    }
  }

  @Override
  public String toString() {
    return partOfSolution ? "x" : symbol.getSymbol();
  }

  private enum TileType {
    START("S"),
    END("E"),
    FREE("0"),
    WALL("1");

    private final String symbol;

    TileType(String symbol) {
      this.symbol = symbol;
    }

    public String getSymbol() {
      return symbol;
    }

    static Optional<TileType> of(String symbol) {
      return Arrays.stream(TileType.values())
          .filter(t -> t.symbol.equalsIgnoreCase(symbol))
          .findFirst();
    }
  }
}
