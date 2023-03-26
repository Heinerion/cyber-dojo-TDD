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
        workingCopy[row][col] = new Tile(maze[row][col]);
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
    if (workingCopy[row][col].isNotVisited()) {
      visit(row, col);
    }
  }

  private void visit(int row, int col) {
    List<Tile> neighbors = getNeighbors(row, col);
    List<Tile> visitedNeighbours = neighbors.stream().filter(Tile::isVisited).collect(Collectors.toList());

    // we are looking for the last leaf of a single branch
    if (visitedNeighbours.size() <= 1) {
      visitLeaf(workingCopy[row][col], neighbors, visitedNeighbours);
    }
  }

  private void visitLeaf(Tile field, List<Tile> neighbors, List<Tile> visitedNeighbours) {
    boolean isPossibleBridge = neighbors.stream().anyMatch(Tile::isPotentialNextStep);
    boolean hasVisitedNeighbour = !visitedNeighbours.isEmpty();
    Tile predecessor = visitedNeighbours.stream().findFirst().orElse(null);

    // The check for the end tile has to go first.
    // Otherwise, the end tile could be considered a "bridge" and the end condition would never be met
    if (hasVisitedNeighbour && field.isEnd()) {
      markAsVisited(field, predecessor);
      endReached = true;
      markSolution(field);
    } else if (field.isStart()
        || hasVisitedNeighbour && isPossibleBridge) {
      markAsVisited(field, predecessor);
    }
  }

  private void markAsVisited(Tile field, Tile predecessor) {
    field.setPredecessor(predecessor);
    field.setVisited(true);
  }

  private void markSolution(Tile field) {
    field.setPartOfSolution(true);
    Tile parent = field.getPredecessor();
    while (parent != null) {
      parent.setPartOfSolution(true);
      parent = parent.getPredecessor();
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
}
