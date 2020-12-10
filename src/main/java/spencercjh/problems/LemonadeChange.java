package spencercjh.problems;

import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
public class LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
    int countFive = 0;
    int countTen = 0;
    for (int bill : bills) {
      switch (bill) {
        case 5:
          countFive++;
          break;
        case 10:
          if (countFive == 0) {
            return false;
          }
          countFive--;
          countTen++;
          break;
        case 20:
          if (countTen >= 1 && countFive >= 1) {
            countTen--;
            countFive--;
          } else if (countFive >= 3) {
            countFive -= 3;
          } else {
            return false;
          }
          break;
        default:
          break;
      }
    }
    return true;
  }
}
