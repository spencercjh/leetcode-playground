package spencercjh.problems;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * @author spencercjh
 */
@Singleton
public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    final Map<Character, Integer> frequency = new HashMap<>();
    int maxExec = 0;
    for (char ch : tasks) {
      final int exec = frequency.getOrDefault(ch, 0) + 1;
      frequency.put(ch, exec);
      maxExec = Math.max(maxExec, exec);
    }
    int maxCount = 0;
    for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
      if (entry.getValue() == maxExec) {
        ++maxCount;
      }
    }
    return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
  }
}
