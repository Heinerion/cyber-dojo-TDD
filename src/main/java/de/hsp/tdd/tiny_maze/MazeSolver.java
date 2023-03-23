package de.hsp.tdd.tiny_maze;

import java.util.*;

public class MazeSolver {

  public static final String START = "S";
  public static final String END = "E";
  public static final String WALL = "1";
  public static final String FREE = "0";
  public static final String VISITED = "x";

  int maxRow;
  int maxCol;

  private String[][] workingCopy;
  boolean endReached = false;

  public String[][] solve(String[][] maze) {
    maxRow = maze.length;
    maxCol = maze[0].length;

    workingCopy = new String[maxRow][maxCol];
    for (int row = 0; row < maxRow; row++) {
      workingCopy[row] = Arrays.copyOf(maze[row], maxCol);
    }

    while (!endReached) {
      updateWorkingCopy();
    }

    return workingCopy;
  }

  private void updateWorkingCopy() {
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (updateField(row, col)) {
          return;
        }
      }
    }
  }

  private boolean updateField(int row, int col) {
    String symbol = workingCopy[row][col];
    if (symbol.equalsIgnoreCase(WALL)
        || symbol.equalsIgnoreCase(VISITED)) {
      return false;
    }

    return visit(row, col, symbol);
  }

  private boolean visit(int row, int col, String symbol) {
    List<String> neighbors = getNeighbors(row, col);
    boolean isStart = symbol.equalsIgnoreCase(START);
    boolean hasVisitedNeighbour = neighbors.contains(VISITED);
    boolean isPossibleBridge = neighbors.contains(END) || neighbors.contains(FREE);
    boolean isEnd = symbol.equalsIgnoreCase(END);

    if (isStart
        || hasVisitedNeighbour && isPossibleBridge) {
      workingCopy[row][col] = VISITED;
      return true;
    }

    if (hasVisitedNeighbour && isEnd) {
      workingCopy[row][col] = VISITED;
      endReached = true;
      return true;
    }

    return false;
  }

  private List<String> getNeighbors(int row, int col) {
    List<String> neighbours = new ArrayList<>();
    getIfInBounds(row - 1, col).ifPresent(neighbours::add);
    getIfInBounds(row + 1, col).ifPresent(neighbours::add);
    getIfInBounds(row, col - 1).ifPresent(neighbours::add);
    getIfInBounds(row, col + 1).ifPresent(neighbours::add);
    return neighbours;
  }

  private Optional<String> getIfInBounds(int row, int col) {
    return row >= 0 && col >= 0 && row < maxRow && col < maxCol
        ? Optional.of(workingCopy[row][col])
        : Optional.empty();
  }
}
