package spencercjh.problems;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author spencercjh
 */
class LargestNumber {

  private static final String ZERO = "0";

  public String largestNumber(int[] nums) {
    final String[] numStrings = Arrays.stream(nums)
      .mapToObj(String::valueOf)
      .sorted((a, b) -> (b + a).compareTo(a + b))
      .toArray(String[]::new);
    if (ZERO.equals(numStrings[0])) {
      return ZERO;
    }
    return String.join("", numStrings);
  }
}
