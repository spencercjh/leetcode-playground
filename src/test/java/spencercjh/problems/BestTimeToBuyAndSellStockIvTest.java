package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class BestTimeToBuyAndSellStockIvTest {

  @Inject
  private BestTimeToBuyAndSellStockIv solution;

  @Test
  void maxProfit() {
    assertEquals(2, solution.maxProfit(2, new int[]{2, 4, 1}));
    assertEquals(7, solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
  }
}
