package com.max.practice.excercise;

//https://leetcode.com/problems/unique-binary-search-trees/
/*
* Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*
* (Input: 1, 2, 3, 4, 5) forms output(1, 2, 5, 14, 42) - these are Catalan Number's Sequence
*
* G(n) - the nth Catalan Number
* F(i,n) - with at i at the root and #'s [1,2,3,..,n] node available
*
* G(3) = F(1, 3) + F(2, 3) + F(3, 3)
*
*                         G(3)
*                   /      |       \
*           F(1,3)     F(2, 3)       F(3,3)
*           /   \       /   \         /    \
*      G(0)   *  G(2)  G(1) * G(1)   G(2) * G(0)
*                ....                ....
*
* G(0) = 1
*
* F(i,n) = G(i-1) * G(n-i)
* */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                dp[k] += dp[i - 1] * dp[k - i];
            }
        }

        return dp[n];
    }

}
