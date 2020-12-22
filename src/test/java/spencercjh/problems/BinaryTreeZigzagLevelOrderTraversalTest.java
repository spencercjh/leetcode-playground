package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import spencercjh.TreeNode;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class BinaryTreeZigzagLevelOrderTraversalTest {

  @Inject
  private BinaryTreeZigzagLevelOrderTraversal solution;

  @Test
  void zigzagLevelOrder() {
    final TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    final List<List<Integer>> expect = List.of(List.of(3), List.of(20, 9), List.of(15, 7));
    final List<List<Integer>> actual = solution.zigzagLevelOrder(root);
    for (int i = 0, expectSize = expect.size(); i < expectSize; i++) {
      assertEquals(expect.get(i).size(), actual.get(i).size());
      for (int j = 0; j < expect.get(i).size(); j++) {
        assertEquals(expect.get(i).get(j), actual.get(i).get(j));
      }
    }
  }
}
