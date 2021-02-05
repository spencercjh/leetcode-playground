package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 *
 * @author spencercjh
 */
@Singleton
public class GetEqualSubstringsWithinBudget {

  public int equalSubstring(String s, String t, int maxCost) {
    int left = 0;
    final char[] a = s.toCharArray();
    final char[] b = t.toCharArray();
    for (int i = 0, cost = 0; i < a.length; i++) {
      cost += Math.abs(a[i] - b[i]);
      if (cost > maxCost) {
        cost -= Math.abs(a[left] - b[left]);
        left++;
      }
    }
    return a.length - left;
  }

}
