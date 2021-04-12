package spencercjh.problems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * @author spencercjh
 */
class UglyNumberIi {
  private final static int[] FACTORS = new int[]{2, 3, 5};

  public int nthUglyNumber(int n) {
    if (n == 1) {
      return n;
    }
    final PriorityQueue<Long> heap = new PriorityQueue<>();
    final Set<Long> used = new HashSet<>();
    long ugly = 1L;
    heap.offer(ugly);
    used.add(ugly);
    while (n-- > 0) {
      if (heap.isEmpty()) {
        break;
      }
      ugly = heap.poll();
      for (int factor : FACTORS) {
        final long next = ugly * factor;
        if (!used.contains(next)) {
          used.add(next);
          heap.offer(next);
        }
      }
    }
    return (int) ugly;
  }
}
