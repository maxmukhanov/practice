package com.max.practice.excercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeleteNodeAndReturnForest {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> res = new LinkedList<>();
    Set<Integer> toDelete = new HashSet<>();
    for (int i : to_delete) {
      toDelete.add(i);
    }

    deleteNodes(root, toDelete, true, res);
    return res;
  }

  private TreeNode deleteNodes(TreeNode root, Set<Integer> toDelete, boolean isRoot, List<TreeNode> res) {
    if (root == null) return null;

    int val = root.val;
    boolean deleted = toDelete.contains(val);
    if (isRoot && !deleted) res.add(root);

    root.left = deleteNodes(root.left, toDelete, deleted, res);
    root.right = deleteNodes(root.right, toDelete, deleted, res);


    return deleted ? null : root;
  }
}
