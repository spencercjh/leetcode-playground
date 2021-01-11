package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/summary-ranges/
 *
 * @author spencercjh
 */
@Singleton
public class SummaryRanges {

  public List<String> summaryRanges(int[] nums) {
    final List<String> result = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      final int low = i++;
      while (i < nums.length && nums[i] - nums[i - 1] == 1) {
        i++;
      }
      final int high = i - 1;
      final StringBuilder range = new StringBuilder(Integer.toString(nums[low]));
      if (low < high) {
        range.append("->").append(nums[high]);
      }
      result.add(range.toString());
    }
    return result;
  }

}
