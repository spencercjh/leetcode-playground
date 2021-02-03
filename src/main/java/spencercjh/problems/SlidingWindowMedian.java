package spencercjh.problems;

import javax.inject.Singleton;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-median/
 *
 * @author spencercjh
 */
@Singleton
public class SlidingWindowMedian {

  private final PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
  private final PriorityQueue<Integer> larger = new PriorityQueue<>(Integer::compareTo);
  private final Map<Integer, Integer> delayed = new HashMap<>();
  private int k;
  private int smallerSize = 0;
  private int largerSize = 0;

  public double[] medianSlidingWindow(int[] nums, int k) {
    this.k = k;

    for (int i = 0; i < k; i++) {
      insert(nums[i]);
    }

    final double[] answer = new double[nums.length - k + 1];
    answer[0] = getMedian();

    for (int i = k; i < nums.length; i++) {
      insert(nums[i]);
      erase(nums[i - k]);
      answer[i - k + 1] = getMedian();
    }

    return answer;
  }

  @SuppressWarnings("ConstantConditions")
  private double getMedian() {
    return k % 2 == 0 ? ((double) larger.peek() + (double) smaller.peek()) / 2 : smaller.peek();
  }

  private void insert(int num) {
    if (smaller.isEmpty() || num <= smaller.peek()) {
      smaller.offer(num);
      smallerSize++;
    } else {
      larger.offer(num);
      largerSize++;
    }
    makeBalance();
  }

  private void erase(int num) {
    delayed.put(num, delayed.getOrDefault(num, 0) + 1);
    if (!smaller.isEmpty() && num <= smaller.peek()) {
      --smallerSize;
      if (num == smaller.peek()) {
        prune(smaller);
      }
    } else if (!larger.isEmpty()) {
      --largerSize;
      if (num == larger.peek()) {
        prune(larger);
      }
    }
    makeBalance();
  }

  private void makeBalance() {
    if (smallerSize > largerSize + 1) {
      larger.offer(smaller.poll());
      --smallerSize;
      ++largerSize;
      prune(smaller);
    } else if (smallerSize < largerSize) {
      smaller.offer(larger.poll());
      --largerSize;
      ++smallerSize;
      prune(larger);
    }
  }

  private void prune(PriorityQueue<Integer> heap) {
    while (!heap.isEmpty()) {
      final int top = heap.peek();
      if (delayed.containsKey(top)) {
        delayed.put(top, delayed.getOrDefault(top, 0) - 1);
        if (delayed.get(top) == 0) {
          delayed.remove(top);
        }
        heap.poll();
      } else {
        break;
      }
    }
  }
}
