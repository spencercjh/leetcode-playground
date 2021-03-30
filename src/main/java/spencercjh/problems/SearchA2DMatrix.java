package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @author spencercjh
 */
public class SearchA2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    final int rowIndex = firstColumnBinarySearch(matrix, target);
    if (rowIndex < 0) {
      return false;
    }
    return rowBinarySearch(matrix[rowIndex], target);
  }

  private int firstColumnBinarySearch(int[][] matrix, int target) {
    int left = -1;
    int right = matrix.length - 1;
    while (left < right) {
      final int middle = left + (right - left + 1) / 2;
      if (matrix[middle][0] > target) {
        right = middle - 1;
      } else {
        left = middle;
      }
    }
    return left;
  }

  private boolean rowBinarySearch(int[] row, int target) {
    int left = 0;
    int right = row.length - 1;
    while (left <= right) {
      final int middle = left + (right - left) / 2;
      if (row[middle] == target) {
        return true;
      } else if (row[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return false;
  }
}
