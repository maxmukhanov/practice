package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PrintReversedLinkedListTest {
    private PrintReversedLinkedList sut = new PrintReversedLinkedList();

    @Test
    public void shouldPrintReversedLinkedList() {
        StringBuilder sb = new StringBuilder();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        sut.print(sb, head);

        assertThat(sb.toString()).isEqualTo("5->4->3->2->1");
    }
}