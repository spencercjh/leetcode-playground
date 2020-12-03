package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    final int total = nums1.length + nums2.length;
    if (total % 2 == 1) {
      return getKthElement(nums1, nums2, total / 2 + 1);
    } else {
      return (getKthElement(nums1, nums2, total / 2) +
        getKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
    }
  }

  private int getKthElement(int[] nums1, int[] nums2, int k) {
    for (int index1 = 0, index2 = 0; ; ) {
      if (index1 == nums1.length) {
        return nums2[index2 + k - 1];
      }
      if (index2 == nums2.length) {
        return nums1[index1 + k - 1];
      }
      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }
      final int newIndex1 = Math.min(index1 + k / 2, nums1.length) - 1;
      final int newIndex2 = Math.min(index2 + k / 2, nums2.length) - 1;
      if (nums1[newIndex1] <= nums2[newIndex2]) {
        k -= newIndex1 - index1 + 1;
        index1 = newIndex1 + 1;
      } else {
        k -= newIndex2 - index2 + 1;
        index2 = newIndex2 + 1;
      }
    }
  }
}
