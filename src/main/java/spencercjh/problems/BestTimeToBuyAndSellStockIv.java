package spencercjh.problems;

import javax.inject.Singleton;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author spencercjh
 */
@Singleton
public class BestTimeToBuyAndSellStockIv {

  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    k = Math.min(k, prices.length / 2);
    final int[] buy = new int[k + 1];
    final int[] sell = new int[k + 1];

    buy[0] = -prices[0];
    sell[0] = 0;
    for (int i = 1; i <= k; ++i) {
      buy[i] = sell[i] = Integer.MIN_VALUE / 2;
    }

    for (int i = 1; i < prices.length; ++i) {
      buy[0] = Math.max(buy[0], sell[0] - prices[i]);
      for (int j = 1; j <= k; ++j) {
        buy[j] = Math.max(buy[j], sell[j] - prices[i]);
        sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
      }
    }

    return Arrays.stream(sell).max().getAsInt();
  }
}
