package com.max.practice.excercise;

//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        return isMatchTwoPointers(s, p);
    }

    //Use two pointers. time O(nm), space O(1)
    public boolean isMatchTwoPointers(String s, String p) {
        int i = 0, j = 0, lastStarPosition = -1, matchPosition = 0;

        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && (p.charAt(j) == '*')) {
                lastStarPosition = j;
                matchPosition = i;
                j++;
            } else {
                if (lastStarPosition != -1) {
                    j = lastStarPosition + 1;
                    matchPosition++;
                    i = matchPosition;
                } else {
                    return false;
                }
            }
        }

        while (j < p.length() && p.charAt(j) == '*') j++;

        return j == p.length();
    }

    //use DP, time O(nm), space O(nm)
    public boolean isMatchTopDown(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = p.charAt(j - 1) == '*' && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = false;
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[n][m];
    }

    // time O(2^(n*m)), space O(n*m) for stack?
    public boolean isMatchBottomUp(String s, String p) {
        return isMatchBottomUp(s, p, 0, 0);
    }

    private boolean isMatchBottomUp(String s, String p, int startS, int startP) {
        if (startS == s.length() && startP == p.length()) {
            return true;
        }

        //we reached the end of pattern, but not the end to string
        if (startP == p.length()) {
            return false;
        }

        //we reached the end of string, we need to check all remaining characters of pattern if the are all '*' then it's a match
        if (startS == s.length()) {
            return p.charAt(startP) == '*' && isMatchBottomUp(s, p, startS, startP + 1);
        }

        if (s.charAt(startS) == p.charAt(startP) || p.charAt(startP) == '?') {
            return isMatchBottomUp(s, p, startS + 1, startP + 1);
        } else if (p.charAt(startP) == '*'){
            return isMatchBottomUp(s, p, startS, startP + 1) || isMatchBottomUp(s, p, startS + 1, startP);
        } else {
            return false;
        }
    }
}
