package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class NumberOfOperationsToMakeNetworkConnectedTest {

  @Inject
  private NumberOfOperationsToMakeNetworkConnected solution;

  @Test
  void makeConnected() {
    assertEquals(1, solution.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    assertEquals(2, solution.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    assertEquals(-1, solution.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
  }

}
