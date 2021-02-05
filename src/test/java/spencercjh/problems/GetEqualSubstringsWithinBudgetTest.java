package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class GetEqualSubstringsWithinBudgetTest {

  @Inject
  private GetEqualSubstringsWithinBudget solution;

  @Test
  void equalSubstring() {
    assertEquals(3, solution.equalSubstring("abcd", "bcdf", 3));
    assertEquals(1, solution.equalSubstring("abcd", "cdef", 3));
    assertEquals(1, solution.equalSubstring("abcd", "acde", 0));
  }

}
