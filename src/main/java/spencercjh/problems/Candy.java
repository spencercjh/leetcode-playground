package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/candy/
 *
 * @author spencercjh
 */
@Singleton
public class Candy {

  public int candy(int[] ratings) {
    final int[] leftResult = new int[ratings.length];
    for (int i = 0; i < ratings.length; i++) {
      if (i > 0 && ratings[i - 1] < ratings[i]) {
        leftResult[i] = leftResult[i - 1] + 1;
      } else {
        leftResult[i] = 1;
      }
    }
    int result = 0, right = 1;
    for (int i = ratings.length - 1; i >= 0; i--) {
      if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
        right++;
      } else {
        right = 1;
      }
      result += Math.max(leftResult[i], right);
    }
    return result;
  }

}
