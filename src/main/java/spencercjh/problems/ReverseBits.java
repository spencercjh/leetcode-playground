package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * @author spencercjh
 */
public class ReverseBits {

  /**
   * you need treat n as an unsigned value
   */
  public int reverseBits(int n) {
    int answer = 0;
    for (int i = 0; i < Integer.SIZE; i++) {
      // get the last bit and shift left it to high position
      answer |= (n & 1) << (Integer.SIZE - 1 - i);
      // shift right n 1 bit for next iteration
      n >>>= 1;
    }
    return answer;
  }
}
