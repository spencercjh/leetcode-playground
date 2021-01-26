package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author spencercjh
 */
@Singleton
public class LongestContinuousIncreasingSubsequence {

  @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length <= 1) {
      return nums.length;
    }

    int ans = 0;
    for (int i = 0, start = 0; i < nums.length; i++) {
      // restart
      if (i > 0 && nums[i] <= nums[i - 1]) {
        start = i;
      }
      ans = Math.max(ans, i - start + 1);
    }
    return ans;
  }

}
