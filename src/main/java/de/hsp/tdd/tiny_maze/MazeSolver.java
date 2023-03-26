package de.hsp.tdd.tiny_maze;

import java.util.*;
import java.util.stream.Collectors;

public class MazeSolver {

  public static final String START = "S";
  public static final String END = "E";
  public static final String WALL = "1";
  public static final String FREE = "0";

  int numRows;
  int numCols;

  private Tile[][] workingCopy;
  boolean endReached = false;

  public String[][] solve(String[][] maze) {
    numRows = maze.length;
    numCols = maze[0].length;

    initWorkingCopy(maze);
    while (!endReached) {
      updateWorkingCopy();
    }
    return convert(workingCopy);
  }

  private void initWorkingCopy(String[][] maze) {
    workingCopy = new Tile[numRows][numCols];
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        workingCopy[row][col] = new Tile(Type.of(maze[row][col]).orElse(null));
      }
    }
  }

  private String[][] convert(Tile[][] workingCopy) {
    String[][] result = new String[numRows][numCols];
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        result[row][col] = String.valueOf(workingCopy[row][col]);
      }
    }
    return result;
  }

  private void updateWorkingCopy() {
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        updateField(row, col);
      }
    }
  }

  private void updateField(int row, int col) {
    Tile field = workingCopy[row][col];
    if (!field.is(Type.WALL) && !field.visited) {
      visit(row, col);
    }
  }

  private void visit(int row, int col) {
    List<Tile> neighbors = getNeighbors(row, col);
    List<Tile> visitedNeighbours = neighbors.stream().filter(t -> t.visited).collect(Collectors.toList());

    // we are looking for the last leaf of a single branch
    if (visitedNeighbours.size() <= 1) {
      visitLeaf(workingCopy[row][col], neighbors, visitedNeighbours);
    }
  }

  private void visitLeaf(Tile field, List<Tile> neighbors, List<Tile> visitedNeighbours) {
    boolean isPossibleBridge = neighbors.stream().anyMatch(t -> t.is(Type.END) || !t.visited && t.is(Type.FREE));
    boolean hasVisitedNeighbour = !visitedNeighbours.isEmpty();
    Tile predecessor = visitedNeighbours.stream().findFirst().orElse(null);

    // The check for the end tile has to go first.
    // Otherwise, the end tile could be considered a "bridge" and the end condition would never be met
    if (hasVisitedNeighbour && field.is(Type.END)) {
      markAsVisited(field, predecessor);
      endReached = true;
      markSolution(field);
    } else if (field.is(Type.START)
        || hasVisitedNeighbour && isPossibleBridge) {
      markAsVisited(field, predecessor);
    }
  }

  private void markAsVisited(Tile field, Tile predecessor) {
    field.precessor = predecessor;
    field.visited = true;
  }

  private void markSolution(Tile field) {
    field.partOfSolution = true;
    Tile parent = field.precessor;
    while (parent != null) {
      parent.partOfSolution = true;
      parent = parent.precessor;
    }
  }

  private List<Tile> getNeighbors(int row, int col) {
    List<Tile> neighbours = new ArrayList<>();
    getIfInBounds(row - 1, col).ifPresent(neighbours::add);
    getIfInBounds(row + 1, col).ifPresent(neighbours::add);
    getIfInBounds(row, col - 1).ifPresent(neighbours::add);
    getIfInBounds(row, col + 1).ifPresent(neighbours::add);
    return neighbours;
  }

  private Optional<Tile> getIfInBounds(int row, int col) {
    return row >= 0 && col >= 0 && row < numRows && col < numCols
        ? Optional.of(workingCopy[row][col])
        : Optional.empty();
  }

  public static String stringify(String[][] maze) {
    List<String> rows = new ArrayList<>();
    for (String[] row : maze) {
      rows.add(String.join(" ", row));
    }
    return String.join("\n", rows);
  }

  private static final class Tile {
    private final Type symbol;
    private Tile precessor;

    private boolean visited;
    private boolean partOfSolution;

    private Tile(Type initialSymbol) {
      this.symbol = initialSymbol;
    }

    boolean is(Type type) {
      return type == symbol;
    }

    @Override
    public String toString() {
      return partOfSolution ? "x" : symbol.symbol;
    }
  }

  private enum Type {
    START(MazeSolver.START),
    END(MazeSolver.END),
    FREE(MazeSolver.FREE),
    WALL(MazeSolver.WALL);

    private final String symbol;

    Type(String symbol) {
      this.symbol = symbol;
    }

    static Optional<Type> of(String symbol) {
      return Arrays.stream(Type.values())
          .filter(t -> t.symbol.equalsIgnoreCase(symbol))
          .findFirst();
    }
  }
}
