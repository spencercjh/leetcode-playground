package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author spencercjh
 */
@Singleton
public class FibonacciNumber {

  public int fib(int n) {
    if (n < 2) {
      return n;
    }
    int result = 1;
    for (int i = 2, p, q = 0; i <= n; i++) {
      p = q;
      q = result;
      result = p + q;
    }
    return result;
  }

}
