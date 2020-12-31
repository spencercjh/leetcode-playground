package spencercjh.problems;

import javax.inject.Singleton;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * @author spencercjh
 */
@Singleton
public class NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null || intervals.length <= 1) {
      return 0;
    }
    Arrays.sort(intervals, (array1, array2) -> {
      if (array1[0] != array2[0]) {
        return array1[0] - array2[0];
      } else {
        return array1[1] - array2[1];
      }
    });
    int count = 0;
    for (int i = 0, j = 1; i < intervals.length && j < intervals.length; i++, j++) {
      if (intervals[i][1] > intervals[j][0]) {
        i = intervals[i][1] < intervals[j][1] ? i - 1 : j - 1;
        count++;
      } else {
        i = j - 1;
      }
    }
    return count;
  }

}
