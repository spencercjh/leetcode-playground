package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class BestTimeToBuyAndSellStockWithTransactionFeeTest {

  @Inject
  private BestTimeToBuyAndSellStockWithTransactionFee solution;

  @Test
  void maxProfit() {
    assertEquals(8, solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
  }

}
