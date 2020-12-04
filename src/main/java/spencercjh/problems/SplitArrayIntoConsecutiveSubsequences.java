package spencercjh.problems;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * @author spencercjh
 */
@Singleton
public class SplitArrayIntoConsecutiveSubsequences {
  public boolean isPossible(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    final Map<Integer, Integer> numsCountMap = new HashMap<>(((int) (nums.length / 0.75)));
    final Map<Integer, Integer> numsEndMap = new HashMap<>(((int) (nums.length / 0.75)));
    for (int num : nums) {
      numsCountMap.put(num, numsCountMap.getOrDefault(num, 0) + 1);
      if (!numsEndMap.containsKey(num)) {
        numsEndMap.put(num, 0);
      }
    }
    for (int num : nums) {
      if (numsCountMap.get(num) > 0) {
        numsCountMap.put(num, numsCountMap.get(num) - 1);
        if (numsEndMap.getOrDefault(num - 1, 0) > 0) {
          numsEndMap.put(num - 1, numsEndMap.get(num - 1) - 1);
          numsEndMap.put(num, numsEndMap.get(num) + 1);
        } else {
          final int countNextOne = numsCountMap.getOrDefault(num + 1, 0);
          final int countNextTwo = numsCountMap.getOrDefault(num + 2, 0);
          if (countNextOne > 0 && countNextTwo > 0) {
            numsCountMap.put(num + 1, countNextOne - 1);
            numsCountMap.put(num + 2, countNextTwo - 1);
            numsEndMap.put(num + 2, numsEndMap.get(num + 2) + 1);
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }
}
