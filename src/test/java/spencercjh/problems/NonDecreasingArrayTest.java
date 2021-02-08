package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class NonDecreasingArrayTest {

  @Inject
  private NonDecreasingArray solution;

  @Test
  void checkPossibility() {
    assertTrue(solution.checkPossibility(new int[]{4, 2, 3}));
    assertFalse(solution.checkPossibility(new int[]{4, 2, 1}));
    assertTrue(solution.checkPossibility(new int[]{1, 1, 1}));
    assertFalse(solution.checkPossibility(new int[]{3, 4, 2, 3}));
  }

}
