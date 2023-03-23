package de.hsp.tdd.tiny_maze;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MazeSolverTest {

  @Test
  void solves_a_simple_horizontal_step() {
    String[][] maze = {{"S", "E"}};
    String[][] expected = {{"x", "x"}};
    assertArrayEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_simple_horizontal_line() {
    String[][] maze = {{"S", "0", "E"}};
    String[][] expected = {{"x", "x", "x"}};
    assertArrayEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_simple_vertical_step() {
    String[][] maze = {{"S"}, {"E"}};
    String[][] expected = {{"x"}, {"x"}};
    assertArrayEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_simple_vertical_line() {
    String[][] maze = {{"S"}, {"0"}, {"E"}};
    String[][] expected = {{"x"}, {"x"}, {"x"}};
    assertArrayEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_diagonal() {
    String[][] maze = {
        {"S", "0", "1"},
        {"1", "0", "1"},
        {"1", "0", "E"}
    };
    String[][] expected = {
        {"x", "x", "1"},
        {"1", "x", "1"},
        {"1", "x", "x"}
    };
    assertArrayEquals(expected, new MazeSolver().solve(maze));
  }
}
