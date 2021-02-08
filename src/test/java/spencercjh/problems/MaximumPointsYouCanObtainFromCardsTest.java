package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MaximumPointsYouCanObtainFromCardsTest {

  @Inject
  private MaximumPointsYouCanObtainFromCards solution;

  @Test
  void maxScore() {
    assertEquals(12, solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    assertEquals(4, solution.maxScore(new int[]{2, 2, 2}, 2));
    assertEquals(55, solution.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    assertEquals(1, solution.maxScore(new int[]{1, 1000, 1}, 1));
  }

}
