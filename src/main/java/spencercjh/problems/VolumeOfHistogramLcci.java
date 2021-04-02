package spencercjh.problems;

/**
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 *
 * @author spencercjh
 */
class VolumeOfHistogramLcci {
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int answer = 0;
    while (left < right) {
      leftMax = Math.max(height[left], leftMax);
      rightMax = Math.max(height[right], rightMax);
      if (height[left] < height[right]) {
        answer += leftMax - height[left];
        left++;
      } else {
        answer += rightMax - height[right];
        right--;
      }
    }
    return answer;
  }
}
