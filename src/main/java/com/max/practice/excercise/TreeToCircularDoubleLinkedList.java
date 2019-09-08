package com.max.practice.excercise;

public class TreeToCircularDoubleLinkedList {

    public DListNode toDoubleLinkedList(TreeNode root) {
        DListNode node = toDList(root);

        return node.prev;
    }

    public DListNode toDList(TreeNode root) {
        DListNode dummy = new DListNode(0);
        if (root == null) return dummy;

        DListNode left =  toDList(root.left);
        DListNode right = toDList(root.right);

        DListNode listNode = new DListNode(root.val);

        if (left.next != null) {
            left.next.next = listNode;
            listNode.prev = left.next;
        }
        if (right.prev != null) {
            right.prev.prev = listNode;
            listNode.next = right.prev;
        }

        if (left.prev == null) {
            dummy.prev = listNode;
        } else {
            dummy.prev = left.prev;
        }
        if (right.next == null) {
            dummy.next = listNode;
        } else {
            dummy.next = right.next;
        }

        return dummy;
    }
}
