package spencercjh.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/rabbits-in-forest/
 *
 * @author spencercjh
 */
class RabbitsInForest {
  public int numRabbits(int[] answers) {
    if (answers == null || answers.length == 0) {
      return 0;
    }
    final Map<Integer, Integer> count = new HashMap<>(((int) (answers.length / 0.75)));
    for (int y : answers) {
      count.put(y, count.getOrDefault(y, 0) + 1);
    }
    int sum = 0;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      int y = entry.getKey();
      int x = entry.getValue();
      sum += (x + y) / (y + 1) * (y + 1);
    }
    return sum;
  }
}
