package com.max.practice.excercise;

import java.util.LinkedList;

/*https://leetcode.com/problems/sliding-window-maximum/*/
public class MaximumSlidingWindow {

//    Brute force solution O(N*k)

//    Optimized solution time O(N) and space O(K)
//    Use deque. Can look to head and tail with constant time.
//    Store in deque of max size k indexes of elements.
//    Head contains maximum element of k window
//    If head contains maximum of past window - remove from head
//    Compare new element with tail. If tail less than new element - remove from tail until deque is empty or element
//    in deque is greater than new element
//    Add new element to tail
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <=0 || nums.length < k) return new int[]{};

        int n = nums.length;
        int [] windows = new int[n - k + 1];

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (!deque.isEmpty() && deque.peek() == i - k) deque.pop();

            while(!deque.isEmpty() && nums[deque.peekLast()] < num){
                deque.removeLast();
            }

            deque.offer(i);
            if (i - k + 1 >= 0) {
                windows[i - k + 1] = nums[deque.peek()];
            }
        }

        return windows;
    }
}
