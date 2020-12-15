package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 *
 * @author spencercjh
 */
@Singleton
public class MonotoneIncreasingDigits {

  public int monotoneIncreasingDigits(int n) {
    final char[] numbers = String.valueOf(n).toCharArray();
    int nineBeginIndex = numbers.length;
    for (int i = numbers.length - 1; i >= 1; i--) {
      if (numbers[i] < numbers[i - 1]) {
        nineBeginIndex = i;
        numbers[i - 1]--;
      }
    }
    for (int i = nineBeginIndex; i < numbers.length; i++) {
      numbers[i] = '9';
    }
    return Integer.parseInt(new String(numbers));
  }
}
