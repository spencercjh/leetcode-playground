package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class StringToIntegerAtoi {
  /**
   * @param s number string
   * @return number
   * @see Integer#parseInt(String)
   */
  public int myAtoi(String s) {
    boolean numberBegin = false;
    boolean positive = true;
    int result = 0;
    for (char c : s.toCharArray()) {

      if (!numberBegin) {
        if (c == ' ') {
          continue;
        }
        if (c == '-' || c == '+') {
          positive = c == '+';
          numberBegin = true;
          continue;
        } else if (isDigit(c)) {
          numberBegin = true;
        } else {
          return 0;
        }
      }

      if (!isDigit(c)) {
        // number end
        break;
      } else {
        final int d = positive ? c - '0' : -(c - '0');
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && d > 7)) {
          return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && d < -8)) {
          return Integer.MIN_VALUE;
        }
        result = result * 10 + d;
      }
    }
    return result;
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
}
