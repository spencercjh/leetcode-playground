package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 *
 * @author spencercjh
 */
@Singleton
public class MaximumAverageSubarrayI {

  public double findMaxAverage(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    // loop is obviously faster than stream api on LeetCode
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int maxSum = sum;
    for (int i = k; i < nums.length; i++) {
      sum = sum - nums[i - k] + nums[i];
      maxSum = Math.max(maxSum, sum);
    }
    return (double) maxSum / k;
  }

}
