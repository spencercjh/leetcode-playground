package spencercjh.problems;

import javax.inject.Singleton;
import java.util.Arrays;

/**
 * @author spencercjh
 */
@Singleton
public class ZigzagConversion {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    final String[] rows = new String[numRows];
    Arrays.fill(rows, "");
    int row = 0;
    boolean goDown = true;
    for (char ch : s.toCharArray()) {
      rows[row] += ch;
      if (row == numRows - 1) {
        goDown = false;
      } else if (row == 0) {
        goDown = true;
      }
      if (goDown) {
        row++;
      } else {
        row--;
      }
    }
    final StringBuilder ans = new StringBuilder();
    for (String value : rows) {
      ans.append(value);
    }
    return ans.toString();
  }
}
