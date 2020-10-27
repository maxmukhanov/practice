package com.max.practice.excercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalImpl1 implements TreeTraversal {
    @Override
    public List<Integer> inOrderRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        inOrderRecImpl(root, list);
        return list;

    }

    private void inOrderRecImpl(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderRecImpl(root.left, list);
            list.add(root.val);
            inOrderRecImpl(root.right, list);
        }
    }

    @Override
    public List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    @Override
    public List<Integer> preOrderRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preOrderRecImpl(root, list);
        return list;
    }

    private void preOrderRecImpl(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrderRecImpl(root.left, list);
            preOrderRecImpl(root.right, list);
        }
    }

    @Override
    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            root = st.pop();

            list.add(root.val);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }


        return list;
    }

    @Override
    public List<Integer> postOrderRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postOrderRecImpl(root, list);
        return list;
    }

    private void postOrderRecImpl(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                postOrderRecImpl(root.left, list);
            }

            if (root.right != null) {
                postOrderRecImpl(root.right, list);
            }

            list.add(root.val);
        }
    }


    @Override
    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();

        TreeNode lastVisitedNode = null;
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                TreeNode peek = st.peek();

                if (peek.right != null && peek.right != lastVisitedNode) {
                    root = peek.right;
                } else {
                    lastVisitedNode = st.pop();
                    list.add(lastVisitedNode.val);
                }
            }
        }


        return list;
    }
}
