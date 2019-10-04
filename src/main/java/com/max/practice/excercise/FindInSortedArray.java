package com.max.practice.excercise;

public class FindInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1, -1};

    int left = findLeftIndex(nums, target);
    if (left == -1) return new int [] {-1, -1};
    int right = findRightIndex(nums, target, left);

    return new int[]{left, right};
  }

  public int findLeftIndex(int [] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;

    while(lo <= hi) {
      int mid = (hi + lo) / 2;

      if (nums[lo] == target) return lo;

      if (nums[lo] < target && nums[mid] >= target) {
        lo++;
        hi = mid;
      } else if (nums[hi] >= target && nums[mid] < target) {
        lo = mid + 1;
      } else {
        return -1;
      }
    }

    return -1;
  }

  public int findRightIndex(int [] nums, int target, int start) {
    int lo = start;
    int hi = nums.length - 1;

    while(lo <= hi) {
      int mid = (hi + lo) / 2;

      if (nums[hi] == target) return hi;

      if (nums[hi] > target && nums[mid] <= target) {
        lo = mid;
        hi--;
      } else if (nums[lo] <= target && nums[mid] > target) {
        hi = mid - 1;
      } else {
        return -1;
      }
    }

    return -1;
  }
}
