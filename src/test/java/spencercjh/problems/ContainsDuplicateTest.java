package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@MicronautTest
class ContainsDuplicateTest {
  @Inject
  private ContainsDuplicate solution;

  @Test
  void containsDuplicate() {
    assertTrue(solution.containsDuplicate(new int[]{1, 2, 2, 3}));
    assertFalse(solution.containsDuplicate(new int[]{1,2}));
    assertFalse(solution.containsDuplicate(new int[]{1}));
  }
}
