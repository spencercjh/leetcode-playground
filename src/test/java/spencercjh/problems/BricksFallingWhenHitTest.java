package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@MicronautTest
class BricksFallingWhenHitTest {

  @Inject
  private BricksFallingWhenHit solution;

  @Test
  void hitBricks() {
    assertArrayEquals(new int[]{2}, solution.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}},
      new int[][]{{1, 0}}));
    assertArrayEquals(new int[]{0, 0}, solution.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}},
      new int[][]{{1, 1}, {1, 0}}));
  }

}
