package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m-- + n-- - 1;
    while (m >= 0 && n >= 0) {
      nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
    }
    while (n >= 0) {
      nums1[i--] = nums2[n--];
    }
  }
}
