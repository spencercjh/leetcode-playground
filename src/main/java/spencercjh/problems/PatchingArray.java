package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/patching-array/
 *
 * @author spencercjh
 */
@Singleton
public class PatchingArray {

  public int minPatches(int[] nums, int n) {
    long max = 1;
    int index = 0, result = 0;
    while (max <= n) {
      if (index < nums.length && nums[index] <= max) {
        max += nums[index++];
      } else {
        max += max;
        result++;
      }
    }
    return result;
  }
}
