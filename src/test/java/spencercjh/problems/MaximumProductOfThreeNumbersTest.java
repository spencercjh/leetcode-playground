package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MaximumProductOfThreeNumbersTest {

  @Inject
  private MaximumProductOfThreeNumbers solution;

  @Test
  void maximumProduct() {
    assertEquals(6, solution.maximumProduct(new int[]{1, 2, 3}));
    assertEquals(24, solution.maximumProduct(new int[]{1, 2, 3, 4}));
    assertEquals(24, solution.maximumProduct(new int[]{1, 2, -3, -4}));
  }

}
