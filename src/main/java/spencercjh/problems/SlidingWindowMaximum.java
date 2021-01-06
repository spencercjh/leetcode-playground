package spencercjh.problems;

import javax.inject.Singleton;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author spencercjh
 */
@Singleton
public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    final PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) ->
      p1.value != p2.value ? p2.value - p1.value : p2.index - p1.index);
    for (int i = 0; i < k; i++) {
      maxHeap.offer(new Pair(nums[i], i));
    }
    final int[] ans = new int[nums.length - k + 1];
    if (maxHeap.peek() != null) {
      ans[0] = maxHeap.peek().value;
    } else {
      return new int[]{};
    }
    for (int i = k; i < nums.length; i++) {
      maxHeap.offer(new Pair(nums[i], i));
      while (maxHeap.peek() != null && maxHeap.peek().index <= i - k) {
        maxHeap.poll();
      }
      if (maxHeap.peek() != null) {
        ans[i - k + 1] = maxHeap.peek().value;
      }
    }
    return ans;
  }

  private static class Pair {
    private final int value;
    private final int index;

    public Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
