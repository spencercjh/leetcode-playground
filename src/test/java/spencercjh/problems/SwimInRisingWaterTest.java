package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SwimInRisingWaterTest {

  @Inject
  private SwimInRisingWater solution;

  @Test
  void swimInWater() {
    assertEquals(3, solution.swimInWater(new int[][]{{0, 2}, {1, 3}}));
    assertEquals(16, solution.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16},
      {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
  }

}
