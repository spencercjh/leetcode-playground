package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author spencercjh
 */
@Singleton
public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    final char[] charArrayS = s.toCharArray();
    final char[] charArrayT = t.toCharArray();
    final char[] characterMapping = new char[255];
    final boolean[] isCharacterMapped = new boolean[255];
    for (int i = 0; i < charArrayS.length; i++) {
      final char characterS = charArrayS[i];
      final char characterT = charArrayT[i];
      if (characterMapping[characterS] == 0) {
        if (isCharacterMapped[characterT]) {
          return false;
        }
        characterMapping[characterS] = characterT;
        isCharacterMapped[characterT] = true;
      } else if (characterMapping[characterS] != characterT) {
        return false;
      }
    }
    return true;
  }

}
