package com.max.practice.excercise;

public class OneEditApart {

    boolean isOneEditApart(String w1, String w2) {
        if (w1 == null || w2 == null) throw new IllegalArgumentException();
        if (w1.length() < w2.length()) return isOneEditApart(w2, w1);
        if (w1.length() - w2.length() > 1) return false;

        boolean sawDiff = false;


        for (int i = 0, j = 0; j < w2.length(); i++, j++) {
            if (w1.charAt(i) != w2.charAt(j)) {
                if (sawDiff) return false;
                sawDiff = true;
                if (w1.length() != w2.length())j--;
            }
        }
        return sawDiff || w1.length() != w2.length();
    }
}
