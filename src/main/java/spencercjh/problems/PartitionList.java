package spencercjh.problems;

import spencercjh.ListNode;

import javax.inject.Singleton;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * @author spencercjh
 */
@Singleton
public class PartitionList {

  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    // begin with dummy
    ListNode small = new ListNode(0);
    ListNode big = new ListNode(0);
    final ListNode smallHead = small;
    final ListNode bigHead = big;
    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        big.next = head;
        big = big.next;
      }
      head = head.next;
    }
    big.next = null;
    small.next = bigHead.next;
    return smallHead.next;
  }
}
