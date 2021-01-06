package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 *
 * @author spencercjh
 */
@Singleton
public class PositionsOfLargeGroups {

  public List<List<Integer>> largeGroupPositions(String s) {
    final List<List<Integer>> result = new ArrayList<>();
    final char[] chars = s.toCharArray();
    for (int i = 0, sequenceLength = 0; i < chars.length; i++) {
      if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
        sequenceLength++;
      } else {
        if (sequenceLength >= 3) {
          result.add(List.of(i - sequenceLength + 1, i));
        }
        sequenceLength = 1;
      }
    }
    return result;
  }

}
