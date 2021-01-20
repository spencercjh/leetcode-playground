package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author spenncercjh
 */
@Singleton
public class CountAndSay {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    final String str = countAndSay(n - 1);
    final char[] chars = str.toCharArray();
    final StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0, count = 1; i < chars.length; i++) {
      if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
        stringBuilder.append(count).append(chars[i]);
        count = 1;
      } else {
        count++;
      }
    }
    return stringBuilder.toString();
  }
}
