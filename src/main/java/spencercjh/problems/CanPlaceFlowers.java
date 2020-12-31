package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 *
 * @author spencercjh
 */
@Singleton
public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length && n > 0; ) {
      // there is a flower in the current flowerpot
      if (flowerbed[i] == 1) {
        i += 2;
      }
      // Both current and next flowerpots are empty, can place one
      else if (flowerbed[i] == 0 && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
        i += 2;
        n--;
      } else {
        i++;
      }
    }
    return n == 0;
  }

}
