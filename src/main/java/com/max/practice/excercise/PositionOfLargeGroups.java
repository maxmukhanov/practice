package com.max.practice.excercise;

import java.util.*;

//https://leetcode.com/problems/positions-of-large-groups/
public class PositionOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new LinkedList<>();

        if (s == null || s.length() < 3) return ans;
        int left = 0;
        int right = left;

        while (right < s.length()) {
            while (right < s.length() && s.charAt(left) == s.charAt(right)) right++;
            if (right - left >= 3) ans.add(Arrays.asList(left, right - 1));
            left = right;
        }
        return ans;
    }
}
