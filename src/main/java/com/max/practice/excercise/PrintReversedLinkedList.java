package com.max.practice.excercise;

public class PrintReversedLinkedList {

    public void print(StringBuilder sb, ListNode node) {
        if (node == null) return;
        print(sb, node.next);
        if(sb.length() != 0) sb.append("->");
        sb.append(node.val);
    }
}
