package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class NonOverlappingIntervalsTest {

  @Inject
  private NonOverlappingIntervals solution;

  @Test
  void eraseOverlapIntervals() {
    assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 3}, {1, 5}, {2, 4}}));
    assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
    assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1, 2}}));
  }
}
