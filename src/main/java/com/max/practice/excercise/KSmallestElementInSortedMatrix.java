package com.max.practice.excercise;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
/*
* Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.
*
* */
public class KSmallestElementInSortedMatrix {

    /*
    * Use heap(Java Priority Queue). time O(klog(k)), space O(k)
    *
    * 1. Put first row in a min heap. We need to track elements value and position in a heap
    * 2. From 1 to k do the following:
    *    Poll min element from min-heap. If element col+1 exists in matrix, add it to min-heap
    *
    * 3. Poll element from min-heap, it will be the answer
    * */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for(int j = 0; j < k && j < m; j++) heap.offer(new int[]{matrix[0][j], 0, j});

        while (--k > 0) {
            int[] tuple = heap.poll();
            int ii = tuple[1];
            int jj = tuple[2];
            if (ii + 1 < n) {
                heap.offer(new int[]{matrix[ii + 1][jj], ii + 1, jj});
            }
        }

        return heap.poll()[0];
    }
}
