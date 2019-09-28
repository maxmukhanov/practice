package com.max.practice.excercise;

public class CountSort {

    public String sort(String str) {
        int[] counts = new int[26];
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            counts[ch - 'a']++;
        }

        int k = 0;
        for(int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                int count = counts[i];
                while (count > 0) {
                    arr[k++] =  (char)('a' + i);
                    count--;
                }
            }
        }

        return new String(arr);
    }
}
