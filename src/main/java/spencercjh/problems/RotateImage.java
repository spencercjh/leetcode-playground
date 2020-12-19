package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author spencercjh
 */
@Singleton
public class RotateImage {

  public void rotate(int[][] matrix) {
    // circle nums
    for (int i = 0; i < matrix.length / 2; i++) {
      // begin -> end row index
      int end = matrix.length - 1 - i;
      for (int j = 0; j < end - i; j++) {
        int temp = matrix[i][i + j];
        matrix[i][i + j] = matrix[end - j][i];
        matrix[end - j][i] = matrix[end][end - j];
        matrix[end][end - j] = matrix[i + j][end];
        matrix[i + j][end] = temp;
      }
    }
  }
}
