package spencercjh.problems;

import spencercjh.ListNode;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @author spencercjh
 */
@Singleton
public class RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    ListNode fast = head;
    int length = 1;
    while (fast.next != null) {
      length++;
      fast = fast.next;
    }
//    System.out.println(length);
    ListNode slow = head;
    int rotate = length - k % length;
    if (rotate == 0 || rotate == length) {
      return head;
    }
    for (int i = 0; i < rotate - 1; i++) {
      slow = slow.next;
    }
//    System.out.println(slow.val);
    final ListNode newHead = slow.next;
    slow.next = null;
    fast.next = head;
    return newHead;
  }

}
