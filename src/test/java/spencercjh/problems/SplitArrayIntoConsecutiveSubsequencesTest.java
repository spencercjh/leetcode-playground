package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class SplitArrayIntoConsecutiveSubsequencesTest {
  @Inject
  private SplitArrayIntoConsecutiveSubsequences solution;

  @Test
  void isPossible() {
    assertTrue(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    assertTrue(solution.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
  }
}
