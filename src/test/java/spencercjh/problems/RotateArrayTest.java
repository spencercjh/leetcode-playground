package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static spencercjh.AssertionUtils.assertArrayEquals;

@MicronautTest
class RotateArrayTest {

  @Inject
  private RotateArray solution;

  @Test
  void rotate() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7};
    solution.rotate(nums, 3);
    assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
  }
}
