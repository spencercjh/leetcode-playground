package spencercjh.problems;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * @author spencercjh
 */
@Singleton
public class MostStonesRemovedWithSameRowOrColumn {

  private Map<Integer, Integer> parents;
  private int count = 0;

  public int removeStones(int[][] stones) {
    if (stones == null || stones.length <= 1) {
      return 0;
    }
    parents = new HashMap<>((int) ((2 * stones.length) / 0.75));
    for (int[] stone : stones) {
      union(~stone[0], stone[1]);
    }
    return stones.length - count;
  }


  private int find(int n) {
    if (!parents.containsKey(n)) {
      parents.put(n, n);
      count++;
    }

    if (n != parents.get(n)) {
      parents.put(n, find(parents.get(n)));
    }

    return parents.get(n);
  }

  private void union(int x, int y) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    parents.put(rootX, rootY);
    count--;
  }
}
