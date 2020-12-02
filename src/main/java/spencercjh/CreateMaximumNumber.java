package spencercjh;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/create-maximum-number/
 *
 * @author spencercjh
 */
@Singleton
public class CreateMaximumNumber {

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] maxSequence = new int[k];
    for (int i = 0; i <= Math.min(k, Math.max(nums1.length, nums2.length)); i++) {
      final int[] seq1 = getSubMaxSequence(nums1, i);
      final int[] seq2 = getSubMaxSequence(nums2, k - i);
      final int[] merged = merge(seq1, seq2);
      if (isLargerSequence(merged, maxSequence)) {
        maxSequence = merged;
      }
    }
    return maxSequence;
  }

  private boolean isLargerSequence(int[] merged, int[] maxSequence) {
    if (merged.length != maxSequence.length) {
      return merged.length > maxSequence.length;
    }
    for (int i = 0; i < merged.length; i++) {
      if (merged[i] == maxSequence[i]) {
        continue;
      }
      return merged[i] > maxSequence[i];
    }
    return true;
  }

  int[] merge(int[] seq1, int[] seq2) {
    final int mergedLength = seq1.length + seq2.length;
    final int[] merged = new int[mergedLength];
    for (int i = 0, p1 = 0, p2 = 0; i < merged.length; i++) {
      // return true if the former is big or the the latter is out of bounds, vice versa
      if (compare(seq1, p1, seq2, p2)) {
        merged[i] = seq1[p1++];
      } else {
        merged[i] = seq2[p2++];
      }
    }
    return merged;
  }

  private boolean compare(int[] seq1, int p1, int[] seq2, int p2) {
    while (p1 < seq1.length && p2 < seq2.length) {
      if (seq1[p1] != seq2[p2]) {
        return seq1[p1] > seq2[p2];
      }
      p1++;
      p2++;
    }
    return seq1.length - p1 > seq2.length - p2;
  }

  int[] getSubMaxSequence(int[] nums, int k) {
    if (k == 0) {
      return new int[0];
    }
    final int[] stack = new int[Math.min(nums.length, k)];
    int top = -1;
    int drop = 0;
    for (int num : nums) {
      while (top >= 0 && num > stack[top] && drop < nums.length - k) {
        top--;
        drop++;
      }
      if (top < k - 1) {
        stack[++top] = num;
      } else {
        drop++;
      }
    }
    return stack;
  }
}
