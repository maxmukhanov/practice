package com.max.practice.excercise;

public class LookAndSay {

    public String lookAndSay(String input) {
        if (input == null || input.length() == 0) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();
        char ch = input.charAt(0);
        int count = 0;

        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ch) {
                sb.append(count);
                sb.append(ch);
                count = 1;
                ch = input.charAt(i);
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(ch);

        return sb.toString();
    }
}
