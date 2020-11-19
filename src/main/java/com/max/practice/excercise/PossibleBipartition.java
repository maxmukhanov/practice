package com.max.practice.excercise;

import java.util.*;

public class PossibleBipartition {
    enum Color {
        BLUE,
        GREEN
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Color[] nodeColor = new Color[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int[] dislike : dislikes) {
            int p1 = dislike[0];
            int p2 = dislike[1];
            graph.computeIfAbsent(p1, i -> new LinkedList<>());
            graph.computeIfAbsent(p2, i -> new LinkedList<>());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                nodeColor[i] = Color.BLUE;
                queue.add(i);

                while (!queue.isEmpty()) {
                    Integer u = queue.poll();

                    if (visited[u]) continue;
                    visited[u] = true;

                    if (!graph.containsKey(u)) continue;
                    for (Integer v : graph.get(u)) {
                        if (nodeColor[u] == nodeColor[v]) {
                            return false;
                        }
                        if (nodeColor[u] == Color.BLUE) {
                            nodeColor[v] = Color.GREEN;
                        } else {
                            nodeColor[v] = Color.BLUE;
                        }
                        queue.add(v);
                    }
                }
            }
        }

        return true;
    }
}
