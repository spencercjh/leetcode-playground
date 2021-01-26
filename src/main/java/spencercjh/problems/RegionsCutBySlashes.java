package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/regions-cut-by-slashes/
 *
 * @author spencercjh
 */
@Singleton
public class RegionsCutBySlashes {
  private int[] parent;
  private int count;

  /**
   * ------------------
   * |   0   ||   0   |
   * |3     1||3     1|
   * |   2   ||   2   |
   * ------------------
   * ------------------
   * |   0   ||   0   |
   * |3     1||3     1|
   * |   2   ||   2   |
   * ------------------
   */
  public int regionsBySlashes(String[] grid) {
    final int size = 4 * grid.length * grid.length;

    count = size;
    parent = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < grid.length; i++) {
      final char[] row = grid[i].toCharArray();
      for (int j = 0; j < row.length; j++) {
        final int index = 4 * (i * row.length + j);
        // inside grid
        switch (row[j]) {
          case '/':
            // 0-3 and 1-2
            union(index, index + 3);
            union(index + 1, index + 2);
            break;
          case '\\':
            // 0-1 and 2-3
            union(index, index + 1);
            union(index + 2, index + 3);
            break;
          default:
            // 0-1-2-3
            union(index, index + 1);
            union(index + 1, index + 2);
            union(index + 2, index + 3);
            break;
        }

        // adjacent grid 0-2 and 1-3
        if (j + 1 < grid.length) {
          union(index + 1, 4 * (i * row.length + j + 1) + 3);
        }
        if (i + 1 < grid.length) {
          union(index + 2, 4 * ((i + 1) * row.length + j));
        }
      }
    }
    return count;
  }

  private int find(int n) {
    if (n != parent[n]) {
      parent[n] = find(parent[n]);
    }
    return parent[n];
  }

  private void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
      return;
    }
    parent[x] = y;
    count--;
  }
}
