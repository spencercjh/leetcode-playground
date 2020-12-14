package spencercjh.problems;

import javax.inject.Singleton;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author spencercjh
 */
@Singleton
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<String, List<String>> keyResultMap = new HashMap<>();
    for (String str : strs) {
      final char[] strCharArray = str.toCharArray();
      Arrays.sort(strCharArray);
      final String key = new String(strCharArray);
      final List<String> list = keyResultMap.getOrDefault(key, new ArrayList<>());
      list.add(str);
      keyResultMap.put(key, list);
    }
    return new ArrayList<>(keyResultMap.values());
  }
}
