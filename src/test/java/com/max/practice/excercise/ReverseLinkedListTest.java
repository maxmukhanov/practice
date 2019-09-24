package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ReverseLinkedListTest {

  private ReverseLinkedList sut = new ReverseLinkedList();

  @Test
  public void reverseIterate() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;

    ListNode actual = sut.reverse(node1);

    assertThat(actual).isSameAs(node3);
    assertThat(actual.next).isSameAs(node2);
    assertThat(actual.next.next).isSameAs(node1);
    assertThat(actual.next.next.next).isNull();

  }

  @Test
  public void reverseKgroups() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    ListNode node8 = new ListNode(8);
    ListNode node9 = new ListNode(9);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = node9;

    ListNode actual = sut.reverseKGroup(node1, 4);
    System.out.println(actual.print());
    assertThat(actual).isSameAs(node4);
  }

  @Test
  public void reverseKgroupsOneGroup() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;


    ListNode actual = sut.reverseKGroup(node1, 4);
    System.out.println(actual.print());
    assertThat(actual).isSameAs(node1);
  }
}