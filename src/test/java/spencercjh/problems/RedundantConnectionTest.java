package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static spencercjh.AssertionUtils.assertArrayEquals;

@MicronautTest
class RedundantConnectionTest {

  @Inject
  private RedundantConnection solution;

  @Test
  void findRedundantConnection() {
    assertArrayEquals(new int[]{2, 3}, solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    assertArrayEquals(new int[]{1, 4}, solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
  }

}
