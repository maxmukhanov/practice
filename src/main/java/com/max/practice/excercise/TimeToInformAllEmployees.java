package com.max.practice.excercise;

import java.util.*;

public class TimeToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int man = manager[i];
            graph.computeIfAbsent(man, item -> new ArrayList<>());
            graph.get(man).add(i);
        }

        return dfs(n, headID, graph, informTime);
    }

    private int dfs(int n, int manager, Map<Integer, List<Integer>> graph, int[] informTime) {
        int max = 0;

        if (!graph.containsKey(manager)) {
            return max;
        }

        for (Integer sub : graph.get(manager)) {
            max = Math.max(max, dfs(n, sub, graph, informTime));
        }

        return max + informTime[manager];
    }
}
