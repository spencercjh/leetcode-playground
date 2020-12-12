package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class WiggleSubsequenceTest {
  @Inject
  private WiggleSubsequence solution;

  @Test
  void wiggleMaxLength() {
    assertEquals(7, solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    assertEquals(2, solution.wiggleMaxLength(new int[]{1, 17}));
    assertEquals(3, solution.wiggleMaxLength(new int[]{1, 17, 16}));
    assertEquals(1, solution.wiggleMaxLength(new int[]{1, 1}));
    assertEquals(2, solution.wiggleMaxLength(new int[]{1, 1, 2}));
  }
}
