package de.hsp.tdd.tiny_maze;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MazeSolverTest {

  @Test
  void solves_a_simple_step() {
    String[][] maze = {{"S", "E"}};
    String[][] expected = {{"x", "x"}};
    assertArrayEquals(expected, new MazeSolver().solve(maze));
  }

}
