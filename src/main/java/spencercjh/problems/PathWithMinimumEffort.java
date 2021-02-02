package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 *
 * @author spencercjh
 */
@Singleton
public class PathWithMinimumEffort {

  private int[] parents;

  public int minimumEffortPath(int[][] heights) {
    final int rows = heights.length;
    final int columns = heights[0].length;
    parents = new int[rows * columns];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    final List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        final int id = i * columns + j;
        if (i > 0) {
          // with previous row
          edges.add(new Edge(id - columns, id, Math.abs(heights[i][j] - heights[i - 1][j])));
        }
        if (j > 0) {
          // with previous column;
          edges.add(new Edge(id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])));
        }
      }
    }
    edges.sort(Comparator.comparingInt(edge -> edge.distance));
    int answer = 0;
    for (Edge edge : edges) {
      union(edge.start, edge.end);
      if (isConnected(0, rows * columns - 1)) {
        answer = edge.distance;
        break;
      }
    }

    return answer;
  }

  private int find(int n) {
    if (n != parents[n]) {
      parents[n] = find(parents[n]);
    }
    return parents[n];
  }

  @SuppressWarnings("SameParameterValue")
  private boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }

  @SuppressWarnings("UnusedReturnValue")
  private boolean union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
      return false;
    }
    parents[x] = y;
    return true;
  }

  private static class Edge {
    private final int start;
    private final int end;
    private final int distance;

    private Edge(int start, int end, int distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }
  }
}
