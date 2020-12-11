package spencercjh.problems;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author spencercjh
 */
@Singleton
public class Dota2Senate {

  static final String DIRE = "Dire";
  static final String RADIANT = "Radiant";

  public String predictPartyVictory(String senate) {
    final int n = senate.length();
    final Queue<Integer> radiant = new LinkedList<>();
    final Queue<Integer> dire = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') {
        radiant.offer(i);
      } else {
        dire.offer(i);
      }
    }
    while (!radiant.isEmpty() && !dire.isEmpty()) {
      final int radiantIndex = radiant.poll();
      //noinspection ConstantConditions
      final int direIndex = dire.poll();
      if (radiantIndex < direIndex) {
        radiant.offer(radiantIndex + n);
      } else {
        dire.offer(direIndex + n);
      }
    }
    return radiant.isEmpty() ? DIRE : RADIANT;
  }
}
