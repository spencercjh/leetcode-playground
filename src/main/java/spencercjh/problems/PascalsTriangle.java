package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * @author spencercjh
 */
@Singleton
public class PascalsTriangle {
  /**
   * <p>1</p>
   * <p>1 1</p>
   * <p>1 2 1</p>
   * <p>1 3 3 1</p>
   * <p>1 4 6 4 1</p>
   *
   * @param numRows n
   * @return triangle
   */
  public List<List<Integer>> generate(int numRows) {
    final List<List<Integer>> triangle = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      final List<Integer> row = new ArrayList<>(i + 1);
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
        }
      }
      triangle.add(row);
    }
    return triangle;
  }
}
