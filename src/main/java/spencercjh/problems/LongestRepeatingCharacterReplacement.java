package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 *
 * @author spencercjh
 */
@Singleton
public class LongestRepeatingCharacterReplacement {

  public int characterReplacement(String s, int k) {
    final int[] num = new int[26];
    int max = 0, left = 0, right = 0;
    final char[] chars = s.toCharArray();
    while (right < chars.length) {
      max = Math.max(max, ++num[chars[right] - 'A']);
      if (right - left + 1 - max > k) {
        num[chars[left] - 'A']--;
        left++;
      }
      right++;
    }
    return right - left;
  }
}
