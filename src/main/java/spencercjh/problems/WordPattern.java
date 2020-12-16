package spencercjh.problems;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 *
 * @author spencercjh
 */
@Singleton
public class WordPattern {

  public boolean wordPattern(String pattern, String s) {
    final String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }
    final Map<Character, String> patternWordMap = new HashMap<>();
    for (int i = 0; i < pattern.toCharArray().length; i++) {
      final char ch = pattern.charAt(i);
      if (patternWordMap.containsKey(ch)) {
        if (!patternWordMap.get(ch).equals(words[i])) {
          return false;
        }
      } else {
        if (patternWordMap.containsValue(words[i])) {
          return false;
        } else {
          patternWordMap.put(ch, words[i]);
        }
      }
    }
    return true;
  }
}
