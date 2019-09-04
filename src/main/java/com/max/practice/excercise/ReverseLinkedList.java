package com.max.practice.excercise;

public class ReverseLinkedList {

  public ListNode reverse(ListNode root) {
    ListNode prev = null;
    ListNode current = root;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    ListNode startNode = head;
    ListNode prevStartNode = dummy;

    int i = 1;
    ListNode node = head;
    while (node != null) {
      ListNode next = node.next;
      if (i % k == 0) {
        ListNode nextStartNode = node.next;

        reverse(startNode, nextStartNode);
        prevStartNode.next = node;
        prevStartNode = startNode;
        startNode = nextStartNode;
      }

      node = next;
      i++;
    }

    prevStartNode.next = startNode;

    return dummy.next;
  }

  private ListNode reverse(ListNode startNode, ListNode endNode) {
    ListNode prev = null;
    ListNode node = startNode;
    ListNode next = null;

    while (node != endNode) {
      next = node.next;

      node.next = prev;
      prev = node;
      node = next;
    }
    return prev;
  }
}
