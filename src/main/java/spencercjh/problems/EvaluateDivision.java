package spencercjh.problems;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/evaluate-division/
 *
 * @author spencercjh
 */
@Singleton
public class EvaluateDivision {

  private int[] parents;
  private double[] weights;

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    final int size = equations.size() * 2;
    parents = new int[size];
    weights = new double[size];
    for (int i = 0; i < size; i++) {
      parents[i] = i;
      weights[i] = 1.0;
    }

    final Map<String, Integer> characterIdMapping = new HashMap<>(size);
    for (int i = 0, id = 0; i < equations.size(); i++) {
      final String x = equations.get(i).get(0);
      final String y = equations.get(i).get(1);
      if (!characterIdMapping.containsKey(x)) {
        characterIdMapping.put(x, id++);
      }
      if (!characterIdMapping.containsKey(y)) {
        characterIdMapping.put(y, id++);
      }
      union(characterIdMapping.get(x), characterIdMapping.get(y), values[i]);
    }

    final double[] results = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      final String x = queries.get(i).get(0);
      final String y = queries.get(i).get(1);
      if (!characterIdMapping.containsKey(x) || !characterIdMapping.containsKey(y)) {
        results[i] = -1;
      } else {
        results[i] = isConnected(characterIdMapping.get(x), characterIdMapping.get(y));
      }
    }
    return results;
  }

  public void union(int x, int y, double value) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    parents[rootX] = rootY;
    weights[rootX] = value * weights[y] / weights[x];
  }

  public double isConnected(int x, int y) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return weights[x] / weights[y];
    } else {
      return -1;
    }
  }

  private int find(int node) {
    if (node != parents[node]) {
      final int origin = parents[node];
      parents[node] = find(parents[node]);
      weights[node] *= weights[origin];
    }
    return parents[node];
  }
}
