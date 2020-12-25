package spencercjh.problems;

import javax.inject.Singleton;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author spencercjh
 */
@Singleton
public class AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int result = 0;
    for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
      while (j < s.length && s[j] < g[i]) {
        j++;
      }
      if (j < s.length) {
        result++;
      }
    }
    return result;
  }

}
