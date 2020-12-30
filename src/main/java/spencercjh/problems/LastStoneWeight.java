package spencercjh.problems;

import javax.inject.Singleton;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/last-stone-weight/
 *
 * @author spencercjh
 */
@Singleton
public class LastStoneWeight {

  public int lastStoneWeight(int[] stones) {
    if (stones == null || stones.length == 0) {
      return 0;
    }
    if (stones.length == 1) {
      return stones[0];
    }
    Arrays.sort(stones);
    while (stones[stones.length - 2] != 0) {
      final int max = stones[stones.length - 1];
      final int smaller = stones[stones.length - 2];
      stones[stones.length - 1] = max - smaller;
      stones[stones.length - 2] = 0;
      Arrays.sort(stones);
    }
    return stones[stones.length - 1];
  }

}
