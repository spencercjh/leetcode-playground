package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * @author spencercjh
 */
@Singleton
public class MaximumProductOfThreeNumbers {

  public int maximumProduct(int[] nums) {
    int max = Integer.MIN_VALUE, nextMax = Integer.MIN_VALUE, nextNextMax = Integer.MIN_VALUE,
      min = Integer.MAX_VALUE, nextMin = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num < min) {
        nextMin = min;
        min = num;
      } else if (num < nextMin) {
        nextMin = num;
      }

      if (num > max) {
        nextNextMax = nextMax;
        nextMax = max;
        max = num;
      } else if (num > nextMax) {
        nextNextMax = nextMax;
        nextMax = num;
      } else if (num > nextNextMax) {
        nextNextMax = num;
      }
    }
    return Math.max(nextMin * min * max, max * nextMax * nextNextMax);
  }
}
