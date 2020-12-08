package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * @author spencercjh
 */
@Singleton
public class SplitArrayIntoFibonacciSequence {
  public List<Integer> splitIntoFibonacci(String S) {
    final List<Integer> result = new ArrayList<>();
    backtrack(S.toCharArray(), result, 0);
    return result;
  }

  public boolean backtrack(char[] digits, List<Integer> result, int begin) {
    final int size = result.size();
    if (begin == digits.length && size >= 3) {
      return true;
    }
    for (int index = begin; index < digits.length; index++) {
      if (digits[begin] == '0' && index > begin) {
        break;
      }
      final long currentNum = subDigitsToNum(digits, begin, index);
      if (currentNum > Integer.MAX_VALUE) {
        break;
      }
      if (size >= 2 && result.get(result.size() - 1) + result.get(result.size() - 2) < currentNum) {
        break;
      }
      if (size <= 1 || result.get(result.size() - 1) + result.get(result.size() - 2) == currentNum) {
        result.add((int) currentNum);
        if (backtrack(digits, result, index + 1)) {
          return true;
        }
        result.remove(result.size() - 1);
      }
    }
    return false;
  }

  long subDigitsToNum(char[] digits, int start, int end) {
    long res = 0;
    for (int i = start; i <= end; i++) {
      res = res * 10 + digits[i] - '0';
    }
    return res;
  }
}
