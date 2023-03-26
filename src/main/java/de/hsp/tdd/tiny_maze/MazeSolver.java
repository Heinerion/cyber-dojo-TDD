package de.hsp.tdd.tiny_maze;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class MazeSolver {

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
    workingCopy = convert(maze, new Tile[numRows][numCols], Tile::new);
  }

  private <I, O> O[][] convert(I[][] input, O[][] output, Function<I, O> converter) {
    walkMaze((row, col) -> output[row][col] = converter.apply(input[row][col]));
    return output;
  }

  private void walkMaze(BiConsumer<Integer, Integer> action) {
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        action.accept(row, col);
      }
    }
  }

  private void updateWorkingCopy() {
    walkMaze(this::updateField);
  }

  private void updateField(int row, int col) {
    if (workingCopy[row][col].needsVisit()) {
      visitField(row, col);
    }
  }

  private void visitField(int row, int col) {
    List<Tile> neighbors = getNeighbors(row, col);
    List<Tile> visitedNeighbours = neighbors.stream().filter(Tile::isVisited).collect(Collectors.toList());

    // we are looking for the last leaf of a single branch
    if (visitedNeighbours.size() <= 1) {
      visitLeaf(workingCopy[row][col], neighbors, visitedNeighbours);
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

  private void visitLeaf(Tile field, List<Tile> neighbors, List<Tile> visitedNeighbours) {
    boolean isPossibleBridge = neighbors.stream().anyMatch(Tile::isPotentialNextStep);
    boolean hasVisitedNeighbour = !visitedNeighbours.isEmpty();
    Tile predecessor = visitedNeighbours.stream().findFirst().orElse(null);

    // The check for the end tile has to go first.
    // Otherwise, the end tile could be considered a "bridge" and the end condition would never be met
    if (hasVisitedNeighbour && field.isEnd()) {
      field.markAsVisited(predecessor);
      endReached = true;
      field.markSolution();
    } else if (field.isStart()
        || hasVisitedNeighbour && isPossibleBridge) {
      field.markAsVisited(predecessor);
    }
  }

  private String[][] convert(Tile[][] workingCopy) {
    return convert(workingCopy, new String[numRows][numCols], String::valueOf);
  }

  public static String stringify(String[][] maze) {
    List<String> rows = new ArrayList<>();
    for (String[] row : maze) {
      rows.add(String.join(" ", row));
    }
    return String.join("\n", rows);
  }
}
