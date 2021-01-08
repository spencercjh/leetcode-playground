package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author spencercjh
 */
@Singleton
public class RotateArray {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    for (int startIndex = 0; startIndex < gcd(k, nums.length); startIndex++) {
      int currentIndex = startIndex;
      int currentNum = nums[currentIndex];
      do {
        final int nextIndex = (currentIndex + k) % nums.length;
        final int temp = nums[nextIndex];
        nums[nextIndex] = currentNum;
        currentNum = temp;
        currentIndex = nextIndex;
      } while (startIndex != currentIndex);
    }
  }


  private int gcd(int x, int y) {
    //noinspection SuspiciousNameCombination
    return y > 0 ? gcd(y, x % y) : x;
  }
}
