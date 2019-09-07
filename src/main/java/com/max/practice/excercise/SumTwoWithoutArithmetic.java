package com.max.practice.excercise;

public class SumTwoWithoutArithmetic {

    public int sum(int x, int y) {

        while (y != 0) {
            int carry = x & y;
            x ^= y;
            y = carry << 1;
        }

        return x;
    }

}
