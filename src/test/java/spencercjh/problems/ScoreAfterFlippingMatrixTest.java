package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ScoreAfterFlippingMatrixTest {
  @Inject
  private ScoreAfterFlippingMatrix solution;

  @Test
  void matrixScore() {
    assertEquals(39, solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
  }
}
