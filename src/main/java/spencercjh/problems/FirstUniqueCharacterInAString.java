package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author spencercjh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Singleton
public class FirstUniqueCharacterInAString {

  public int firstUniqChar(String s) {
    int result = Integer.MAX_VALUE;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      final int left = s.indexOf(ch);
      final int right = s.lastIndexOf(ch);
      if (left == right && left != -1) {
        result = Math.min(result, left);
      }
    }
    return result != Integer.MAX_VALUE ? result : -1;
  }

}
