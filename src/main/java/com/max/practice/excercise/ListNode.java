package com.max.practice.excercise;

public class ListNode {
  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        '}';
  }

  public String print() {
    String out = "";
    ListNode node = this;
    while (node != null) {
      out += node.val + "->";
      node = node.next;
    }

    return out;
  }
}
