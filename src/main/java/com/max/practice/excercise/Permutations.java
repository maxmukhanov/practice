package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permutations(Integer[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    permutations(nums, 0, result);
    return result;
  }

  private void permutations(Integer[] nums, int start, List<List<Integer>> result) {
    if (start >= nums.length) {
      result.add(Arrays.asList(nums.clone()));
    } else {
      for (int i = start; i < nums.length; i++) {
        swap(nums, i, start);
        permutations(nums, start + 1, result);
        swap(nums,i, start);
      }
    }
  }

  private void swap(Integer[] nums, int i, int j) {
    if (i != j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}
