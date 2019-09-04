package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

  public static List<Integer> inOrderRecursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inOrderRecursiveImpl(root, result);
    return result;
  }

  private static void inOrderRecursiveImpl(TreeNode root, List<Integer> result) {
    if (root == null) return;

    if (root.left != null) inOrderRecursiveImpl(root.left, result);
    result.add(root.val);
    inOrderRecursiveImpl(root.right, result);
  }

  public static List<Integer> inOrderIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();


    Stack<TreeNode> st = new Stack<>();
    TreeNode node = root;

    while (!st.isEmpty() || node != null) {
      if (node != null) {
        st.push(node);
        node = node.left;
      } else {
        node = st.pop();
        result.add(node.val);
        node = node.right;
      }
    }

    return result;
  }

  public static List<Integer> postOrderTraversalIterative(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();

    TreeNode node = root;
    TreeNode lastVisitedNode = null;
    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        TreeNode peek = stack.peek();
        if (peek.right != null && lastVisitedNode != peek.right) {
          node = peek.right;
        } else {
          res.add(peek.val);
          lastVisitedNode = stack.pop();
        }
      }
    }


    return res;
  }
}
