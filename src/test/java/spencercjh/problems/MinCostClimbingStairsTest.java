package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MinCostClimbingStairsTest {

  @Inject
  private MinCostClimbingStairs solution;

  @Test
  void minCostClimbingStairs() {
    assertEquals(15, solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    assertEquals(6, solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
  }

}
