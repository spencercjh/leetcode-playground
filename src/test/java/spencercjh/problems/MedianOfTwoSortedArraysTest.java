package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MedianOfTwoSortedArraysTest {
  @Inject
  private MedianOfTwoSortedArrays solution;

  @Test
  void findMedianSortedArrays() {
    assertEquals(2, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    assertEquals(4.0, solution.findMedianSortedArrays(new int[]{1, 3, 4, 9},
      new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
  }
}
