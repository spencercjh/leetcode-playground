package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MaximumAverageSubarrayITest {

  @Inject
  private MaximumAverageSubarrayI solution;

  @Test
  void findMaxAverage() {
    assertEquals(12.75, solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    assertEquals(5, solution.findMaxAverage(new int[]{5}, 1));
  }

}
