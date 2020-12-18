package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/find-the-difference/
 *
 * @author spencercjh
 */
@Singleton
public class FindTheDifference {

  public char findTheDifference(String s, String t) {
    char result = 0;
    for (char ch : s.toCharArray()) {
      result ^= ch;
    }
    for (char ch : t.toCharArray()) {
      result ^= ch;
    }
    return result;
  }

}
