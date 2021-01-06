package spencercjh;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 *
 * @author spencercjh
 */
public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode buildListNodeWithValues(int... values) {
    if (values == null || values.length == 0) {
      return new ListNode();
    }
    ListNode head = new ListNode(values[0]);
    ListNode current = head;
    for (int i = 1; i < values.length; i++) {
      current.next = new ListNode(values[i]);
      current = current.next;
    }
    return head;
  }

  public static int[] parseListNodeToArray(ListNode node) {
    if (node == null) {
      return new int[]{};
    }
    final List<Integer> result = new ArrayList<>();
    while (node != null) {
      result.add(node.val);
      node = node.next;
    }
    return result.stream().mapToInt(x -> x).toArray();
  }
}

