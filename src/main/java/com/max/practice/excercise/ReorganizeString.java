package com.max.practice.excercise;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int [] freq = new int[26];

        int max = 0;
        char ch = '?';
        for(int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
            if (freq[S.charAt(i) - 'a'] > max) {
                max = freq[S.charAt(i) - 'a'];
                ch = S.charAt(i);
            }
        }

        if (max - 1 > S.length() - max ) return "";

        char[] res = new char[S.length()];

        int ind = 0;
        while (freq[ch - 'a'] > 0) {
            res[ind] = ch;
            ind+=2;
            freq[ch - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (ind >= S.length()) {
                    ind = 1;
                }
                res[ind] = (char) (i + 'a');
                ind+=2;
                freq[i]--;
            }
        }


        return new String(res);
    }
}
