package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static spencercjh.AssertionUtils.assertArrayEquals;

@MicronautTest
class FairCandySwapTest {

  @Inject
  private FairCandySwap solution;

  @Test
  void fairCandySwap() {
    assertArrayEquals(new int[]{1, 2}, solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2}));
    assertArrayEquals(new int[]{1, 2}, solution.fairCandySwap(new int[]{1, 2}, new int[]{2, 3}));
    assertArrayEquals(new int[]{2, 3}, solution.fairCandySwap(new int[]{2}, new int[]{1, 3}));
    assertArrayEquals(new int[]{5, 4}, solution.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4}));
  }

}
