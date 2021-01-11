package spencercjh.problems;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/
 *
 * @author spencercjh
 */
@Singleton
public class SmallestStringWithSwaps {

  private int[] parents;

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    if (pairs.size() == 0) {
      return s;
    }

    parents = new int[s.length()];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (List<Integer> pair : pairs) {
      final int x = pair.get(0);
      final int y = pair.get(1);
      union(x, y);
    }

    final Map<Integer, PriorityQueue<Character>> map = new HashMap<>(s.length());
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      final int root = find(i);

      if (!map.containsKey(root)) {
        final PriorityQueue<Character> heap = new PriorityQueue<>();
        heap.offer(chars[i]);
        map.put(root, heap);
      } else {
        map.get(root).offer(chars[i]);
      }
    }

    final StringBuilder result = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      result.append(map.get(find(i)).poll());
    }

    return result.toString();
  }

  private void union(int x, int y) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    parents[rootX] = rootY;
  }

  private int find(int node) {
    if (node != parents[node]) {
      parents[node] = find(parents[node]);
    }
    return parents[node];
  }
}
