package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class CheckIfItIsAStraightLineTest {

  @Inject
  private CheckIfItIsAStraightLine solution;

  @Test
  void checkStraightLine() {
    assertTrue(solution.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    assertFalse(solution.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
  }

}
