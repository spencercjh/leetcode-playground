package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 *
 * @author spencercjh
 */
@Singleton
public class BinaryPrefixDivisibleBy5 {

  @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
  public List<Boolean> prefixesDivBy5(int[] A) {
    if (A == null || A.length == 0) {
      return Collections.emptyList();
    }
    final List<Boolean> answers = new ArrayList<>(A.length);
    for (int i = 0, num = 0; i < A.length; i++) {
      // 为prefix进位
      num <<= 1;
      // 加上个位数字
      num += A[i];
      // 最后只判断个位数字
      num %= 10;
      answers.add(num % 5 == 0);
    }
    return answers;
  }

}
