package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 *
 * @author spencercjh
 */
@Singleton
public class MinCostToConnectAllPoints {

  private int[] parents;
  private int[][] points;

  public int minCostConnectPoints(int[][] points) {
    if (points == null || points.length <= 1) {
      return 0;
    }

    this.points = points;
    parents = new int[points.length];
    final List<Edge> edges = new ArrayList<>(points.length * points.length);
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        edges.add(new Edge(i, j));
      }
    }
    edges.sort(Comparator.comparingInt(edge -> edge.length));

    int n = 1;
    int answer = 0;
    for (Edge edge : edges) {
      if (union(edge.x, edge.y)) {
        answer += edge.length;
        if (++n == points.length) {
          break;
        }
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

  private boolean union(int x, int y) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return false;
    }
    parents[rootX] = rootY;
    return true;
  }

  private class Edge {
    final int x;
    final int y;
    final int length;

    private Edge(int x, int y) {
      this.x = x;
      this.y = y;
      // |xi - xj| + |yi - yj|
      this.length = Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
  }
}
