package de.hsp.tdd.tiny_maze;

import java.util.*;

final class Tile {
  private final TileType symbol;
  private Tile predecessor;

  private boolean visited;
  private boolean partOfSolution;

  Tile(TileType initialSymbol) {
    this.symbol = initialSymbol;
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

  boolean is(TileType type) {
    return type == symbol;
  }

  @Override
  public String toString() {
    return partOfSolution ? "x" : symbol.getSymbol();
  }

  enum TileType {
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
