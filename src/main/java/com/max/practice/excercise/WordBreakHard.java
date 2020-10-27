package com.max.practice.excercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakHard {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean [] reach = new boolean[n+1];
        reach[0] = true;

        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                String word = s.substring(j, i + 1);
                if (set.contains(word) && reach[j]) {
                    reach[i+1] = true;
                }
            }
        }

        if (reach[n]) {
            List<String> res = new LinkedList<>();

            dfs(0, reach, res, new StringBuilder(), s, set);

            return res;

        } else {
            return new LinkedList<>();
        }
    }

    void dfs(int start, boolean reach[], List<String> res, StringBuilder sb, String s, Set<String> set) {
        if (start == s.length()) {
            res.add(sb.toString().trim());
            return;
        }

        if (!reach[start]) {
            return;
        }

        for(int i = 1; start + i <= s.length(); i++) {
            String word = s.substring(start, start + i);
            if (set.contains(word)) {
                int beforeLength = sb.length();
                sb.append(word).append(' ');
                dfs(start + i, reach, res, sb, s, set);
                sb.setLength(beforeLength);
            }
        }
    }

}
