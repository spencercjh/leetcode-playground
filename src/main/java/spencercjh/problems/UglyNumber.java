package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 *
 * @author spencercjh
 */
class UglyNumber {
  private static final int[] FACTORS = new int[]{2, 3, 5};

  public boolean isUgly(int n) {
    if (n <= 0) {
      return false;
    }
    for (int factor : FACTORS) {
      while (n % factor == 0) {
        n /= factor;
      }
    }
    return n == 1;
  }
}
