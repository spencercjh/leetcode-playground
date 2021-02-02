package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 *
 * @author spencercjh
 */
@Singleton
public class FairCandySwap {

  private static final int MAX_VALUE = 100000;

  public int[] fairCandySwap(int[] alice, int[] bob) {
    int sumA = 0;
    final boolean[] aliceExisted = new boolean[MAX_VALUE + 1];
    for (int a : alice) {
      aliceExisted[a] = true;
      sumA += a;
    }
    int sumB = 0;
    for (int b : bob) {
      sumB += b;
    }
    final int delta = (sumA - sumB) / 2;
    for (int b : bob) {
      final int a = b + delta;
      if (a >= 0 && a <= MAX_VALUE && aliceExisted[a]) {
        return new int[]{a, b};
      }
    }
    return new int[]{};
  }
}
