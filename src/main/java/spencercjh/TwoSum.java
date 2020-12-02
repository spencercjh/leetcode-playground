package spencercjh;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author spencercjh
 */
@Singleton
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]), i};
      }
      map.put(target - nums[i], i);
    }
    return new int[]{};
  }
}
