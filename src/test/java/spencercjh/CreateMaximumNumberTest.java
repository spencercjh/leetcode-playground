package spencercjh;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class CreateMaximumNumberTest {
  @Inject
  private CreateMaximumNumber solution;

  @Test
  void maxNumber() {
    assertTrue(Arrays.equals(new int[]{9, 8, 6, 5, 3},
      solution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
    assertTrue(Arrays.equals(new int[]{6, 7, 6, 0, 4},
      solution.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
    assertTrue(Arrays.equals(new int[]{9, 8, 9},
      solution.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
    assertTrue(Arrays.equals(new int[]{1, 2},
      solution.maxNumber(new int[]{1, 2}, new int[]{}, 2)));
    assertTrue(Arrays.equals(new int[]{9, 9, 9, 7, 3, 2, 3, 1, 1},
      solution.maxNumber(new int[]{7, 6, 1, 9, 3, 2, 3, 1, 1}, new int[]{4, 0, 9, 9, 0, 5, 5, 4, 7}, 9)));
  }

  @Test
  void getSubMaxSequence() {
    assertTrue(Arrays.equals(new int[]{9, 8, 3}, solution.getSubMaxSequence(new int[]{9, 1, 2, 5, 8, 3}, 3)));
    assertTrue(Arrays.equals(new int[]{9, 5, 8, 3}, solution.getSubMaxSequence(new int[]{9, 1, 2, 5, 8, 3}, 4)));
    assertTrue(Arrays.equals(new int[]{9, 8}, solution.getSubMaxSequence(new int[]{9, 1, 2, 5, 8, 3}, 2)));
    assertTrue(Arrays.equals(new int[]{9}, solution.getSubMaxSequence(new int[]{9, 1, 2, 5, 8, 3}, 1)));
    assertTrue(Arrays.equals(new int[]{9, 8, 4}, solution.getSubMaxSequence(new int[]{9, 1, 2, 5, 8, 3, 4}, 3)));
    assertTrue(Arrays.equals(new int[]{9, 8, 4}, solution.getSubMaxSequence(new int[]{1, 9, 2, 5, 8, 3, 4}, 3)));
    assertTrue(Arrays.equals(new int[]{9, 8, 3, 4}, solution.getSubMaxSequence(new int[]{1, 9, 2, 5, 8, 3, 4}, 4)));
    assertTrue(Arrays.equals(new int[]{1}, solution.getSubMaxSequence(new int[]{1}, 2)));
    assertTrue(Arrays.equals(new int[]{9, 9, 5, 7}, solution.getSubMaxSequence(new int[]{4, 0, 9, 9, 0, 5, 5, 4, 7}, 4)));
  }


  @Test
  void merge() {
    assertTrue(Arrays.equals(new int[]{9, 8, 6, 5, 3}, solution.merge(new int[]{9, 8, 3}, new int[]{6, 5})));
    assertTrue(Arrays.equals(new int[]{6, 7, 6, 0, 4}, solution.merge(new int[]{6, 7}, new int[]{6, 0, 4})));
  }
}
