package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class LongestTurbulentSubarrayTest {

  @Inject
  private LongestTurbulentSubarray solution;

  @Test
  void maxTurbulenceSize() {
    assertEquals(5, solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    assertEquals(2, solution.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
    assertEquals(1, solution.maxTurbulenceSize(new int[]{100}));
  }

}
