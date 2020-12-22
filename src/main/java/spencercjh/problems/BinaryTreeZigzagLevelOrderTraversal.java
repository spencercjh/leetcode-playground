package spencercjh.problems;

import spencercjh.TreeNode;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author spencercjh
 */
@Singleton
public class BinaryTreeZigzagLevelOrderTraversal {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    final List<List<Integer>> answer = new ArrayList<>();
    traverseTree(root, answer, 0);
    return answer;
  }

  private void traverseTree(TreeNode current, List<List<Integer>> result, int level) {
    if (current == null) {
      return;
    }
    if (result.size() == level) {
      result.add(new ArrayList<>());
    }
    if (level % 2 == 0) {
      result.get(level).add(current.val);
    } else {
      result.get(level).add(0, current.val);
    }
    traverseTree(current.left, result, level + 1);
    traverseTree(current.right, result, level + 1);
  }
}
