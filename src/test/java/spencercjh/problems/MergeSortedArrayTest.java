package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MergeSortedArrayTest {
  @Inject
  private MergeSortedArray solution;

  @Test
  void merge() {
    final int[] nums1 = {1, 2, 3, 0, 0, 0};
    solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
    assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 5, 6}, nums1));
  }
}
