package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 *
 * @author spencercjh
 */
@Singleton
public class LongestTurbulentSubarray {

  public int maxTurbulenceSize(int[] arr) {
    int answer = 1;
    for (int i = 1, dp0 = 1, dp1 = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        dp0 = dp1 + 1;
        dp1 = 1;
      } else if (arr[i - 1] < arr[i]) {
        dp1 = dp0 + 1;
        dp0 = 1;
      } else {
        dp0 = 1;
        dp1 = 1;
      }
      answer = Math.max(answer, dp0);
      answer = Math.max(answer, dp1);
    }
    return answer;
  }
}
