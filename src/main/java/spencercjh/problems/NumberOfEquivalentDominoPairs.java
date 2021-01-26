package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 *
 * @author spencercjh
 */
@Singleton
public class NumberOfEquivalentDominoPairs {

  public static final int MAX_VALUE = 100;

  public int numEquivDominoPairs(int[][] dominoes) {
    final int[] values = new int[MAX_VALUE];
    int ans = 0;
    for (int[] dominoe : dominoes) {
      int value;
      if (dominoe[0] < dominoe[1]) {
        value = dominoe[0] * 10 + dominoe[1];
      } else {
        value = dominoe[1] * 10 + dominoe[0];
      }
      ans += values[value]++;
    }
    return ans;
  }
}
