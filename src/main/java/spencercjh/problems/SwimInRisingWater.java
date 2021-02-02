package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/swim-in-rising-water/
 *
 * @author spencercjh
 */
@Singleton
public class SwimInRisingWater {
  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private int n;
  private int[] parents;

  public int swimInWater(int[][] grid) {
    n = grid.length;
    parents = new int[n * n];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    final int[] indices = new int[n * n];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        indices[grid[i][j]] = getIndex(i, j);
      }
    }

    for (int i = 0; i < indices.length; i++) {
      int x = indices[i] / n;
      int y = indices[i] % n;

      for (int[] direction : DIRECTIONS) {
        int newX = x + direction[0];
        int newY = y + direction[1];
        if (inArea(newX, newY) && grid[newX][newY] <= i) {
          union(indices[i], getIndex(newX, newY));
        }

        if (isConnected(0, indices.length - 1)) {
          return i;
        }
      }
    }
    return -1;
  }

  private boolean inArea(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  private boolean isConnected(int x, int y) {
    return find(x) == find(y);
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
  }

  private int getIndex(int i, int y) {
    return i * n + y;
  }
}
