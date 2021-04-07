package spencercjh.problems;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author spencercjh
 */
class SearchInRotatedSortedArrayIi {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    if (nums.length == 1) {
      return nums[0] == target;
    }
    return Arrays.stream(nums)
      .filter(x -> x == target)
      .findFirst()
      .isPresent();
  }
}
