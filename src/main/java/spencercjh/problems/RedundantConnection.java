package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 *
 * @author spencercjh
 */
@Singleton
public class RedundantConnection {

  private int[] parents;

  public int[] findRedundantConnection(int[][] edges) {
    parents = new int[edges.length + 1];
    for (int i = 1; i < parents.length; i++) {
      parents[i] = i;
    }

    for (int[] edge : edges) {
      final int x = edge[0];
      final int y = edge[1];
      if (union(x, y)) {
        return edge;
      }
    }

    return new int[]{};
  }


  private int find(int n) {
    if (n != parents[n]) {
      parents[n] = find(parents[n]);
    }
    return parents[n];
  }

  private boolean union(int x, int y) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return true;
    }
    parents[rootX] = rootY;
    return false;
  }

}
