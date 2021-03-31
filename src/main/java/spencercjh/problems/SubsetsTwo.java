package spencercjh.problems;

import javax.inject.Singleton;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author spencercjh
 */
@Singleton
public class SubsetsTwo {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>(((int) Math.pow(2, nums.length)));
    backtrack(nums, new LinkedList<>(), result, 0);
    return result;
  }

  private void backtrack(int[] nums, LinkedList<Integer> path, List<List<Integer>> result, int startIndex) {
    result.add(new ArrayList<>(path));
    for (int i = startIndex; i < nums.length; i++) {
      if (i > startIndex && nums[i] == nums[i - 1]) {
        continue;
      }
      path.add(nums[i]);
      backtrack(nums, path, result, i + 1);
      path.removeLast();
    }
  }
}
