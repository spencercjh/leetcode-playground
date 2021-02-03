package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static spencercjh.AssertionUtils.assertArrayEquals;

@MicronautTest
class SlidingWindowMedianTest {

  private SlidingWindowMedian solution;

  @Test
  void medianSlidingWindow() {
    solution = new SlidingWindowMedian();
    assertArrayEquals(new double[]{1, -1, -1, 3, 5, 6},
      solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  @Test
  void medianSlidingWindow2() {
    solution = new SlidingWindowMedian();
    assertArrayEquals(new double[]{1}, solution.medianSlidingWindow(new int[]{1}, 1));
  }

  @Test
  void medianSlidingWindow3() {
    solution = new SlidingWindowMedian();
    assertArrayEquals(new double[]{Integer.MAX_VALUE},
      solution.medianSlidingWindow(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2));
  }

}
