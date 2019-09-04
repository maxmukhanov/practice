package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MyLinkedListTest {
  private MyLinkedList ll = new MyLinkedList();

  @Test
  public void test1() {
    ll.addAtHead(1);
    assertThat(ll.get(0)).isEqualTo(1);
    ll.addAtTail(3);
    assertThat(ll.get(0)).isEqualTo(1);
    assertThat(ll.get(1)).isEqualTo(3);
    ll.addAtIndex(1, 2);
    assertThat(ll.get(0)).isEqualTo(1);
    assertThat(ll.get(1)).isEqualTo(2);
    assertThat(ll.get(2)).isEqualTo(3);

  }
}