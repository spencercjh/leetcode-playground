package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * @author spencercjh
 */
@Singleton
public class NonDecreasingArray {

  public boolean checkPossibility(int[] nums) {
    for (int i = 0, count = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        if (++count > 1) {
          return false;
        }
        if (i > 0 && nums[i + 1] < nums[i - 1]) {
          nums[i + 1] = nums[i];
        }
      }
    }
    return true;
  }

}
