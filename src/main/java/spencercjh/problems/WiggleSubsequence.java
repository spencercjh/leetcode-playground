package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class WiggleSubsequence {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int previousDifference = 0;
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      final int currentDifference = nums[i] - nums[i - 1];
      if (currentDifference > 0 && previousDifference <= 0 || currentDifference < 0 && previousDifference >= 0) {
        result++;
        previousDifference = currentDifference;
      }
    }
    return result;
  }
}
