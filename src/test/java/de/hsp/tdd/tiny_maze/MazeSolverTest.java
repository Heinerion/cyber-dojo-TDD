package de.hsp.tdd.tiny_maze;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MazeSolverTest {

  @Test
  void solves_a_simple_horizontal_step() {
    String[][] maze = {{"S", "E"}};
    String[][] expected = {{"x", "x"}};
    assertMazesEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_simple_horizontal_line() {
    String[][] maze = {{"S", "0", "E"}};
    String[][] expected = {{"x", "x", "x"}};
    assertMazesEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_simple_vertical_step() {
    String[][] maze = {{"S"}, {"E"}};
    String[][] expected = {{"x"}, {"x"}};
    assertMazesEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_simple_vertical_line() {
    String[][] maze = {{"S"}, {"0"}, {"E"}};
    String[][] expected = {{"x"}, {"x"}, {"x"}};
    assertMazesEquals(expected, new MazeSolver().solve(maze));
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
    assertMazesEquals(expected, new MazeSolver().solve(maze));
  }

  @Test
  void solves_a_T_shape() {
    String[][] maze = {
        {"S", "0", "0"},
        {"1", "0", "1"},
        {"1", "E", "1"}
    };
    String[][] expected = {
        {"x", "x", "0"},
        {"1", "x", "1"},
        {"1", "x", "1"}
    };

    assertMazesEquals(expected, new MazeSolver().solve(maze));
  }

  private void assertMazesEquals(String[][] expected, String[][] actual) {
    assertEquals(stringify(expected), stringify(actual));
  }

  private String stringify(String[][] expected) {
    List<String> rows = new ArrayList<>();
    for (String[] row : expected
    ) {
      rows.add(String.join(" ", row));
    }
    return String.join("\n", rows);
  }
}
