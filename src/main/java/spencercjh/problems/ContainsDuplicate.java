package spencercjh.problems;

import javax.inject.Singleton;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author spencercjh
 */
@Singleton
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    return IntStream.of(nums).distinct().count() != nums.length;
  }
}
