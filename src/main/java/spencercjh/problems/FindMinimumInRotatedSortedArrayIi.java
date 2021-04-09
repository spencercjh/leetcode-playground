package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author spencercjh
 */
class FindMinimumInRotatedSortedArrayIi {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      final int middle = left + (right - left) / 2;
      if (nums[middle] < nums[right]) {
        right = middle;
      } else if (nums[middle] > nums[right]) {
        left = middle + 1;
      } else {
        right -= 1;
      }
    }
    return nums[left];
  }
}
