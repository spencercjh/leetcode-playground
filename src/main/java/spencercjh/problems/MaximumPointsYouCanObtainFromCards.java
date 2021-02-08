package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * @author spencercjh
 */
@Singleton
public class MaximumPointsYouCanObtainFromCards {

  public int maxScore(int[] cardPoints, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += cardPoints[i];
    }
    int maxSum = sum;
    for (int i = 0; i < k; i++) {
      sum += cardPoints[cardPoints.length - i - 1] - cardPoints[k - i - 1];
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

}
