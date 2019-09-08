package com.max.practice.excercise;

import java.util.Stack;

public class BinarySearchTreeValidator {

//    Idea is to do in-order traversal and keep reference to previous seen element
//    Previous element should be less than current, otherwise BST is invalid
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (prev != null && prev.val >= node.val) {
                return false;
            }

            prev = node;
            node = node.right;
        }

        return true;
    }
}
