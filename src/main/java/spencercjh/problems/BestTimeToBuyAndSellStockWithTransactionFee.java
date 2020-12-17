package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @author spencercjh
 */
@Singleton
public class BestTimeToBuyAndSellStockWithTransactionFee {

  public int maxProfit(int[] prices, int fee) {
    int buy = prices[0] + fee;
    int profit = 0;
    for (int price : prices) {
      if (price + fee < buy) {
        buy = price + fee;
      } else if (price > buy) {
        profit += price - buy;
        buy = price;
      }
    }
    return profit;
  }

}
