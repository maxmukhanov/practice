package com.max.practice.excercise;

import java.util.Stack;

import static com.max.practice.excercise.TreeTraversal.inOrderIterative;

public class BSTtoGST {
  public TreeNode bstToGst(TreeNode root) {
    int sum = inOrderIterative(root).stream().mapToInt(x -> x).sum();

    Stack<TreeNode> st = new Stack<>();
    TreeNode node = root;

    int prevSum = 0;
    while (!st.isEmpty() || node != null) {
      if (node != null) {
        st.push(node);
        node = node.left;
      } else {
        node = st.pop();
        int val = node.val;
        node.val = sum - prevSum;
        prevSum += val;
        node = node.right;
      }
    }

    return root;
  }



}
