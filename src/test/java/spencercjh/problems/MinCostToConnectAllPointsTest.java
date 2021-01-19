package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MinCostToConnectAllPointsTest {

  @Inject
  private MinCostToConnectAllPoints solution;

  @Test
  void minCostConnectPoints() {
    assertEquals(20, solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
  }

}
