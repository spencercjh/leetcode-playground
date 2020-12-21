package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 *
 * @author spencercjh
 */
@Singleton
public class RemoveDuplicateLetters {

  public String removeDuplicateLetters(String s) {
    final char[] chars = s.toCharArray();
    final Deque<Character> deque = new ArrayDeque<>(s.length());
    for (int i = 0; i < chars.length; i++) {
      final char ch = chars[i];
      if (deque.contains(ch)) {
        continue;
      }
      while (!deque.isEmpty() && ch < deque.peek() && s.indexOf(deque.peek(), i) != -1) {
        deque.pop();
      }
      deque.push(ch);
    }
    final StringBuilder result = new StringBuilder();
    deque.descendingIterator().forEachRemaining(result::append);
    return result.toString();
  }
}
