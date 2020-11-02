package com.max.practice.excercise;

import java.util.*;
//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class KPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i < nums1.length; i++) minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});

        while(k-- > 0 && !minHeap.isEmpty()) {
            int [] tuple = minHeap.poll();
            int i = tuple[1];
            int j = tuple[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return res;
    }
}
