package com.max.practice.excercise;

public class BinaryArithmetic {

    public int sum(int x, int y) {

        while (y != 0) {
            int carry = x & y;

            x = x ^ y;
            y = carry << 1;
        }

        return x;
    }

    public int multiply(int x, int y) {
        int sum = 0;

        while (y != 0) {
            sum = (y & 1) == 0 ? sum : sum(sum, x);
            x = x << 1;
            y = y >>> 1;
        }

        return sum;
    }
}
