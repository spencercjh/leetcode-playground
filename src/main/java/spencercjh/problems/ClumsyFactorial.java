package spencercjh.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/clumsy-factorial/
 *
 * @author spencercjh
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class ClumsyFactorial {
  public int clumsy(int N) {
    if (N <= 1) {
      return N;
    }
    final Deque<Integer> stack = new LinkedList<>();
    stack.push(N--);
    for (int i = 0; N > 0; N--, i++) {
      switch (i % 4) {
        case 0:
          stack.push(stack.pop() * N);
          break;
        case 1:
          stack.push(stack.pop() / N);
          break;
        case 2:
          stack.push(N);
          break;
        default:
          stack.push(-N);
          break;
      }
    }
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }
}
