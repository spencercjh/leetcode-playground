package spencercjh.problems;

import javax.inject.Singleton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author spencercjh
 */
@Singleton
public class StringToIntegerAtoi {
  private static final Pattern PATTERN = Pattern.compile("^[+-]?\\d+");

  public int myAtoi(String s) {
    final Matcher matcher = PATTERN.matcher(s.trim());
    if (!matcher.find()) {
      return 0;
    }
    return myParseNumber(matcher.group());
  }

  /**
   * @param s number string
   * @return number
   * @see Integer#parseInt(String)
   */
  int myParseNumber(String s) {
    final boolean negative = !isDigit(s.charAt(0)) && s.charAt(0) == '-';
    final int begin = isDigit(s.charAt(0)) ? 0 : 1;
    int result = 0;
    final int limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
    for (int i = begin; i < s.length(); i++) {
      // Accumulating negatively avoids surprises near MAX_VALUE
      final int digit = s.charAt(i) - '0';
      if (digit < 0 || result < limit / 10) {
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result *= 10;
      if (result < limit + digit) {
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result -= digit;
    }
    return negative ? result : -result;
  }

  private boolean isDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }
}
