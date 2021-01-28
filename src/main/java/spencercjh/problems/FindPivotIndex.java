package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * @author spencercjh
 */
@Singleton
public class FindPivotIndex {

  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return -1;
    }

    // It takes longer to use stream api...
    int total = 0;
    for (int num : nums) {
      total += num;
    }

    for (int i = 0, sum = 0; i < nums.length; i++) {
      if (sum * 2 == total - nums[i]) {
        return i;
      }
      sum += nums[i];
    }
    return -1;
  }
}
