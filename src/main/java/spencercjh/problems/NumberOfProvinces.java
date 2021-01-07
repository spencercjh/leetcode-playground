package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 *
 * @author spencercjh
 */
@Singleton
public class NumberOfProvinces {

  private boolean[] isVisited;
  private int[][] isConnected;

  public int findCircleNum(int[][] isConnected) {
    this.isConnected = isConnected;
    isVisited = new boolean[isConnected.length];
    int circle = 0;
    for (int i = 0; i < isConnected.length; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        dfs(i);
        circle++;
      }
    }
    return circle;
  }

  private void dfs(int city) {
    for (int i = 0; i < isConnected.length; i++) {
      if (isConnected[i][city] == 1 && !isVisited[i]) {
        isVisited[i] = true;
        dfs(i);
      }
    }
  }
}
