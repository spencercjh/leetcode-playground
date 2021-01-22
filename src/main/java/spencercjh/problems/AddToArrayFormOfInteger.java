package spencercjh.problems;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 *
 * @author spencercjh
 */
@Singleton
public class AddToArrayFormOfInteger {

  public static final int BASE = 10;

  @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
  public List<Integer> addToArrayForm(int[] A, int K) {
    final List<Integer> ans = new ArrayList<>();
    for (int i = A.length - 1; i >= 0; i--) {
      int sum = K % BASE + A[i];
      K /= BASE;
      if (sum >= BASE) {
        K++;
        sum -= BASE;
      }
      ans.add(sum);
    }
    for (; K > 0; K /= BASE) {
      ans.add(K % BASE);
    }
    Collections.reverse(ans);
    return ans;
  }

}
