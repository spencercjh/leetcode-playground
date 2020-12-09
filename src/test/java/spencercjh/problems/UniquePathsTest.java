package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class UniquePathsTest {
  @Inject
  private UniquePaths solution;

  @Test
  void uniquePaths() {
    assertEquals(3, solution.uniquePaths(3, 2));
    assertEquals(28, solution.uniquePaths(7, 3));
    assertEquals(1, solution.uniquePaths(1, 1));
  }
}
