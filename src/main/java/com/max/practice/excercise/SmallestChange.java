package com.max.practice.excercise;

public class SmallestChange {

    public int smallestChange(int amount) {
        if (amount <= 0) return 0;

        int coinNumber = 0;
        int[] coins = new int[]{25, 10, 5, 1};

        int i = 0;
        while (amount > 0) {
            coinNumber += amount / coins[i];
            amount %= coins[i];
            i++;
        }
        return coinNumber;
    }

}
