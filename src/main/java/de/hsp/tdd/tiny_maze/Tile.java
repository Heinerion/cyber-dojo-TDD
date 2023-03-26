package de.hsp.tdd.tiny_maze;

import java.util.*;

final class Tile {
  private final TileType symbol;
  private Tile predecessor;

  private boolean visited;
  private boolean partOfSolution;

  Tile(String initialSymbol) {
    this.symbol = Tile.TileType.of(initialSymbol).orElse(null);
  }

  public Tile getPredecessor() {
    return predecessor;
  }

  public void setPredecessor(Tile predecessor) {
    this.predecessor = predecessor;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public void setPartOfSolution(boolean partOfSolution) {
    this.partOfSolution = partOfSolution;
  }

  public boolean isNotVisited() {
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

  @Override
  public String toString() {
    return partOfSolution ? "x" : symbol.getSymbol();
  }

  private enum TileType {
    START(MazeSolver.START),
    END(MazeSolver.END),
    FREE(MazeSolver.FREE),
    WALL(MazeSolver.WALL);

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
