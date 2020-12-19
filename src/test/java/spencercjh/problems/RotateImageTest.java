package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.stream.IntStream;

@MicronautTest
class RotateImageTest {

  @Inject
  private RotateImage solution;

  @Test
  void rotate1() {
    final int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    solution.rotate(input);
    final int[][] expect = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    IntStream.range(0, input.length)
      .mapToObj(i -> Arrays.equals(expect[i], input[i]))
      .forEach(Assertions::assertTrue);
  }

  @Test
  void rotate2() {
    final int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    solution.rotate(input);
    final int[][] expect = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
    IntStream.range(0, input.length)
      .mapToObj(i -> Arrays.equals(expect[i], input[i]))
      .forEach(Assertions::assertTrue);
  }
}
