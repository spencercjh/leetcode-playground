package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/bricks-falling-when-hit/
 *
 * @author spencercjh
 */
@Singleton
public class BricksFallingWhenHit {
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  private int rows;
  private int cols;
  private int[] parents;
  private int[] sizes;

  public int[] hitBricks(int[][] grid, int[][] hits) {
    rows = grid.length;
    cols = grid[0].length;
    final int size = rows * cols;
    parents = new int[size + 1];
    sizes = new int[size + 1];
    for (int i = 0; i < size + 1; i++) {
      parents[i] = i;
      sizes[i] = 1;
    }

    final int[][] copy = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      System.arraycopy(grid[i], 0, copy[i], 0, cols);
    }

    for (int[] hit : hits) {
      copy[hit[0]][hit[1]] = 0;
    }

    for (int j = 0; j < cols; j++) {
      if (copy[0][j] == 1) {
        union(j, size);
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (copy[i][j] == 1) {
          if (copy[i - 1][j] == 1) {
            union(getIndex(i - 1, j), getIndex(i, j));
          }
          if (j > 0 && copy[i][j - 1] == 1) {
            union(getIndex(i, j - 1), getIndex(i, j));
          }
        }
      }
    }

    final int[] res = new int[hits.length];
    for (int i = hits.length - 1; i >= 0; i--) {
      final int x = hits[i][0];
      final int y = hits[i][1];

      if (grid[x][y] == 0) {
        continue;
      }

      int origin = getSize(size);

      if (x == 0) {
        union(y, size);
      }

      for (int[] direction : DIRECTIONS) {
        final int newX = x + direction[0];
        final int newY = y + direction[1];
        if (inArea(newX, newY) && copy[newX][newY] == 1) {
          union(getIndex(x, y), getIndex(newX, newY));
        }
      }

      res[i] = Math.max(0, getSize(size) - origin - 1);
      copy[x][y] = 1;
    }
    return res;
  }


  private boolean inArea(int x, int y) {
    return x >= 0 && x < rows && y >= 0 && y < cols;
  }


  private int getIndex(int x, int y) {
    return x * cols + y;
  }


  public int find(int n) {
    if (n != parents[n]) {
      parents[n] = find(parents[n]);
    }
    return parents[n];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX == rootY) {
      return;
    }
    parents[rootX] = rootY;
    sizes[rootY] += sizes[rootX];
  }

  public int getSize(int n) {
    return sizes[find(n)];
  }
}
