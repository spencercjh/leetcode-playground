package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class BestTimeToBuyAndSellStockIiiTest {

  @Inject
  private BestTimeToBuyAndSellStockIii solution;

  @Test
  void maxProfit() {
    assertEquals(6, solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    assertEquals(4, solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
    assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    assertEquals(0, solution.maxProfit(new int[]{0}));
  }
}
