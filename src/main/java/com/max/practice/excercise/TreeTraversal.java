package com.max.practice.excercise;

import java.util.List;

public interface TreeTraversal {

  List<Integer> inOrderRecursive(TreeNode root);

  List<Integer> inOrderIterative(TreeNode root);

  List<Integer> preOrderRecursive(TreeNode root);
  List<Integer> preOrderIterative(TreeNode root);

  List<Integer> postOrderRecursive(TreeNode root);
  List<Integer> postOrderIterative(TreeNode root);
}
