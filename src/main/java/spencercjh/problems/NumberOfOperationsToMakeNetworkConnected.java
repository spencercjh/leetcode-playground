package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 *
 * @author spencercjh
 */
@Singleton
public class NumberOfOperationsToMakeNetworkConnected {
  private int[] parents;
  private int count;

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }

    count = n;
    parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

    for (int[] connection : connections) {
      union(connection[0], connection[1]);
    }

    return count - 1;
  }

  private int find(int n) {
    if (n != parents[n]) {
      parents[n] = find(parents[n]);
    }
    return parents[n];
  }

  private void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
      return;
    }
    parents[x] = y;
    count--;
  }
}
