package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 *
 * @author spencercjh
 */
@Singleton
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

  public int maxNumEdgesToRemove(int n, int[][] edges) {
    final UnionFind alice = new UnionFind(n);
    final UnionFind bob = new UnionFind(n);
    int ans = 0;

    for (int[] edge : edges) {
      edge[1]--;
      edge[2]--;
    }

    for (int[] edge : edges) {
      if (edge[0] == 3) {
        if (!alice.union(edge[1], edge[2])) {
          ans++;
        } else {
          bob.union(edge[1], edge[2]);
        }
      }
    }

    for (int[] edge : edges) {
      if (edge[0] == 1) {
        if (!alice.union(edge[1], edge[2])) {
          ans++;
        }
      } else if (edge[0] == 2) {
        if (!bob.union(edge[1], edge[2])) {
          ans++;
        }
      }
    }

    if (alice.count != 1 || bob.count != 1) {
      return -1;
    }
    return ans;
  }


  private static class UnionFind {
    private final int[] parents;
    private int count;

    public UnionFind(int n) {
      parents = new int[n];
      count = n;
      for (int i = 0; i < parents.length; i++) {
        parents[i] = i;
      }
    }

    private int find(int n) {
      if (n != parents[n]) {
        parents[n] = find(parents[n]);
      }
      return parents[n];
    }

    public boolean union(int x, int y) {
      x = find(x);
      y = find(y);
      if (x == y) {
        return false;
      }
      parents[x] = y;
      count--;
      return true;
    }
  }
}
