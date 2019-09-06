package com.max.practice.excercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LowerestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    parentMap.put(root, null);
    while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {

      TreeNode node = stack.pop();
      if (node.right != null) {
        stack.push(node.right);
        parentMap.put(node.right, node);
      }
      if (node.left != null) {
        stack.push(node.left);
        parentMap.put(node.left, node);
      }
    }

    Set<TreeNode> ancestors = new HashSet<>();
    while (p != null) {
      ancestors.add(p);
      p = parentMap.get(p);
    }


    while (!ancestors.contains(q)) {
      q = parentMap.get(q);
    }
    return q;
  }
}
