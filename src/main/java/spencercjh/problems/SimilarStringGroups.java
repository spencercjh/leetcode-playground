package spencercjh.problems;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/similar-string-groups/
 *
 * @author spencercjh
 */
@Singleton
public class SimilarStringGroups {
  private int[] parents;

  public int numSimilarGroups(String[] strs) {
    parents = new int[strs.length];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (int i = 0; i < strs.length; i++) {
      for (int j = i + 1; j < strs.length; j++) {
        final int rootI = find(i);
        final int rootJ = find(j);
        if (rootI == rootJ) {
          continue;
        }
        if (check(strs[i].toCharArray(), strs[j].toCharArray())) {
          parents[rootI] = rootJ;
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < parents.length; i++) {
      if (parents[i] == i) {
        answer++;
      }
    }
    return answer;
  }

  private int find(int n) {
    if (n != parents[n]) {
      parents[n] = find(parents[n]);
    }
    return parents[n];
  }

  private boolean check(char[] a, char[] b) {
    int num = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        if (++num > 2) {
          return false;
        }
      }
    }
    return true;
  }

}
