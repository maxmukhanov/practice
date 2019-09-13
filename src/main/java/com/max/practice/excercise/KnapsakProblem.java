package com.max.practice.excercise;

import java.util.HashMap;
import java.util.Map;

public class KnapsakProblem {

    public int maxAmount(int[] weights, int[] cost, int amount) {
        return knapsackDP(weights, cost, amount);
    }

    private int knapsackDP(int[] weights, int[] costs, int amount) {
        int[][] dp = new int[weights.length + 1][amount + 1];

        for (int i = 1; i <= weights.length; i++) {
            int weight = weights[i - 1];
            int cost = costs[i - 1];
            for (int j = 1; j <= amount; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(cost + dp[i - 1][j - weight], dp[i - 1][j -1]);
                }


            }
        }

        return dp[weights.length][amount];
    }

    private int knapsackRecurvive(int[] weights, int[] cost, int amount) {
        Integer[][] memo = new Integer[cost.length][amount + 1];
        return knapsackRecurvive(weights, cost, amount, 0, memo);
    }

    private int knapsackRecurvive(int[] weights, int[] cost, int amount, int i, Integer[][] memo) {
        if (i >= cost.length) return 0;
        if (amount < 0) return 0;

        if (memo[i][amount] != null) return memo[i][amount];
        int max = knapsackRecurvive(weights, cost, amount, i + 1, memo);

        if (amount >= weights[i]) {
            max = Math.max(max, knapsackRecurvive(weights, cost, amount - weights[i], i + 1, memo) + cost[i]);
        }

        memo[i][amount] = max;

        return max;

    }
}
