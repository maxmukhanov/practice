package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalImpl implements TreeTraversal {

  @Override
  public List<Integer> inOrderRecursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inOrderRecursiveImpl(root, result);
    return result;
  }

  void inOrderRecursiveImpl(TreeNode root, List<Integer> result) {
    if (root == null) return;

    if (root.left != null) inOrderRecursiveImpl(root.left, result);
    result.add(root.val);
    inOrderRecursiveImpl(root.right, result);
  }

  @Override
  public  List<Integer> inOrderIterative(TreeNode root) {
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

  @Override
  public List<Integer> preOrderRecursive(TreeNode root) {
    return null;
  }

  @Override
  public List<Integer> preOrderIterative(TreeNode root) {
    return null;
  }

  @Override
  public List<Integer> postOrderRecursive(TreeNode root) {
    return null;
  }

  @Override
  public List<Integer> postOrderIterative(TreeNode root) {
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
