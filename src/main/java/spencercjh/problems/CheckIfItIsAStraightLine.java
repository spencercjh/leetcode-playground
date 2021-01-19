package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 *
 * @author spencercjh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Singleton
public class CheckIfItIsAStraightLine {

  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates == null || coordinates.length == 0) {
      return false;
    }
    if (coordinates.length <= 2) {
      return true;
    }
    final int x0 = coordinates[0][0];
    final int y0 = coordinates[0][1];
    final int x1 = coordinates[1][0];
    final int y1 = coordinates[1][1];
    for (int[] coordinate : coordinates) {
      final int xi = coordinate[0];
      final int yi = coordinate[1];
      if ((yi - y0) * (x1 - x0) != (xi - x0) * (y1 - y0)) {
        return false;
      }
    }
    return true;
  }

}
