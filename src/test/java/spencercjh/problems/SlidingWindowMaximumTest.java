package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class SlidingWindowMaximumTest {

  @Inject
  private SlidingWindowMaximum solution;

  @Test
  void maxSlidingWindow() {
    assertTrue(Arrays.equals(new int[]{3, 3, 5, 5, 6, 7}, solution.maxSlidingWindow(
      new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    assertTrue(Arrays.equals(new int[]{1}, solution.maxSlidingWindow(new int[]{1}, 1)));
    assertTrue(Arrays.equals(new int[]{1, -1}, solution.maxSlidingWindow(new int[]{1, -1}, 1)));
    assertTrue(Arrays.equals(new int[]{11}, solution.maxSlidingWindow(new int[]{9, 11}, 2)));
    assertTrue(Arrays.equals(new int[]{4}, solution.maxSlidingWindow(new int[]{4, -2}, 2)));
  }
}
