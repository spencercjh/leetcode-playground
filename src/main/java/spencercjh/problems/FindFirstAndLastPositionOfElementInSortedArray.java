package spencercjh.problems;

/**
 * @author spencercjh
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[]{-1, -1};
    }
    final int minIndex = binarySearch(nums, target, true);
    final int maxIndex = binarySearch(nums, target, false) - 1;
    if (minIndex <= maxIndex &&
      maxIndex < nums.length &&
      nums[minIndex] == nums[maxIndex] &&
      nums[maxIndex] == target) {
      return new int[]{minIndex, maxIndex};
    }
    return new int[]{-1, -1};
  }

  int binarySearch(int[] nums, int target, boolean isLower) {
    int left = 0;
    int right = nums.length - 1;
    int ans = nums.length;
    while (left <= right) {
      final int mid = (left + right) / 2;
      if (nums[mid] > target || (isLower && nums[mid] >= target)) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
