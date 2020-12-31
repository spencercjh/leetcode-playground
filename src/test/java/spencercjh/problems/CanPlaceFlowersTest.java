package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class CanPlaceFlowersTest {

  @Inject
  private CanPlaceFlowers solution;

  @Test
  void canPlaceFlowers() {
    assertTrue(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    assertFalse(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    assertTrue(solution.canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1));
  }
}
