package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @author spencercjh
 */
@Singleton
public class MaximalRectangle {

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int[][] left = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < left.length; i++) {
      for (int j = 0; j < left[i].length; j++) {
        if (matrix[i][j] == '1') {
          left[i][j] = ((j == 0) ? 0 : left[i][j - 1]) + 1;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < left.length; i++) {
      for (int j = 0; j < left[i].length; j++) {
        if (matrix[i][j] == 0) {
          continue;
        }
        int width = left[i][j];
        int area = width;
        for (int k = i - 1; k >= 0; k--) {
          if (left[k][j] == 0) {
            break;
          }
          width = Math.min(width, left[k][j]);
          area = Math.max(area, (i - k + 1) * width);
        }
        result = Math.max(result, area);
      }
    }
    return result;
  }
}
