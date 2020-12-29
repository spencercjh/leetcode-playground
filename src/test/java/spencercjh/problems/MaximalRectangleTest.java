package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MaximalRectangleTest {

  @Inject
  private MaximalRectangle solution;

  @Test
  void maximalRectangle() {
    assertEquals(6, solution.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}})
    );
    assertEquals(0, solution.maximalRectangle(new char[][]{{'0'}}));
    assertEquals(0, solution.maximalRectangle(new char[][]{{'0', '0'}}));
    assertEquals(1, solution.maximalRectangle(new char[][]{{'1'}}));
  }
}
