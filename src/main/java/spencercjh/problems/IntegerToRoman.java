package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class IntegerToRoman {
  private static final String[] ROMAN_STRINGS = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D",
    "CM", "M"};
  private static final int[] ROMAN_VALUES = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

  public String intToRoman(int num) {
    final StringBuilder answer = new StringBuilder();
    for (int i = ROMAN_VALUES.length - 1; i >= 0; i--) {
      while (ROMAN_VALUES[i] <= num) {
        num -= ROMAN_VALUES[i];
        answer.append(ROMAN_STRINGS[i]);
      }
    }
    return answer.toString();
  }
}
