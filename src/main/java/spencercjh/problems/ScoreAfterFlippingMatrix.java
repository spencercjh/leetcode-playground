package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class ScoreAfterFlippingMatrix {
  public int matrixScore(int[][] A) {
    int rows = A.length, columns = A[0].length;
    // 设最左一列在移动后全为1后
    int answer = rows * (1 << (columns - 1));
    for (int col = 1; col < columns; col++) {
      int oneCount = 0;
      for (int[] row : A) {
        // 判断是否移动过行
        if (row[0] == 1) {
          oneCount += row[col];
        } else {
          oneCount += 1 - row[col];
        }
      }
      answer += Math.max(oneCount, rows - oneCount) * (1 << (columns - col - 1));
    }
    return answer;
  }
}
