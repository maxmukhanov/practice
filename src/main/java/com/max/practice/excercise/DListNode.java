package com.max.practice.excercise;

import java.util.LinkedList;
import java.util.List;

public class DListNode {
    int val;
    DListNode prev;
    DListNode next;

    public DListNode(int val) {
        this.val = val;
    }


    public List<Integer> toList() {
        List<Integer> list = new LinkedList<>();
        DListNode node = this;

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
