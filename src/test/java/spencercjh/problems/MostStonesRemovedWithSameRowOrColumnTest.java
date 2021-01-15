package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MostStonesRemovedWithSameRowOrColumnTest {

  @Inject
  private MostStonesRemovedWithSameRowOrColumn solution;

  @Test
  void removeStones() {
    assertEquals(5, solution.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
  }

}
