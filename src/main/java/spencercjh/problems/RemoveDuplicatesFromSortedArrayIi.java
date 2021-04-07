package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author spencercjh
 */
class RemoveDuplicatesFromSortedArrayIi {

  private static final int THRESHOLD = 2;

  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length <= THRESHOLD) {
      return nums.length;
    }
    int slow = THRESHOLD, fast = THRESHOLD;
    while (fast < nums.length) {
      if (nums[slow - THRESHOLD] != nums[fast]) {
        nums[slow++] = nums[fast];
      }
      fast++;
    }
    return slow;
  }
}
