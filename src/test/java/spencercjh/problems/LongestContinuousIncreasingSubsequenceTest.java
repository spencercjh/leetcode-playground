package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class LongestContinuousIncreasingSubsequenceTest {

  @Inject
  private LongestContinuousIncreasingSubsequence solution;

  @Test
  void findLengthOfLCIS() {
    assertEquals(3, solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    assertEquals(1, solution.findLengthOfLCIS(new int[]{2, 2, 2}));
  }

}
