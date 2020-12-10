package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class LemonadeChangeTest {
  @Inject
  private LemonadeChange solution;

  @Test
  void lemonadeChange() {
    assertTrue(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    assertTrue(solution.lemonadeChange(new int[]{5, 5}));
    assertFalse(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    assertFalse(solution.lemonadeChange(new int[]{10, 10}));
  }
}
