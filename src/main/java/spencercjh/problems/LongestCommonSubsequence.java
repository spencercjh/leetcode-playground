package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * @author spencercjh
 */
class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
      return 0;
    }
    final char[] str1 = text1.toCharArray();
    final char[] str2 = text2.toCharArray();
    final int m = str1.length;
    final int n = str2.length;
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }
}
