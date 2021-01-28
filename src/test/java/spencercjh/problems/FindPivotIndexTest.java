package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class FindPivotIndexTest {

  @Inject
  private FindPivotIndex solution;

  @Test
  void pivotIndex() {
    assertEquals(3, solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    assertEquals(-1, solution.pivotIndex(new int[]{1, 2, 3}));
  }

}
