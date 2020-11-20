package com.max.practice.excercise;

import java.util.*;

public class PossibleBipartition {
    enum Color {
        BLUE,
        GREEN
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        return unionFind(N, dislikes);
    }


    private boolean unionFind(int N, int[][] dislikes) {
        int[] parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        for (int i = 0; i < dislikes.length; i++) {
            int p1 = dislikes[i][0], p2 = dislikes[i][1];

            if (parent[p2] == p2) parent[p2] = p1;
            else {
                int[] uf1 = find(p1, parent), uf2 = find(p2, parent);

                if (uf1[0] == uf2[0] && uf1[1] == uf2[1]) return false;
            }

        }

        return true;
    }

    private int[] find(int p, int[] parent) {
        int color = 0;
        while (parent[p] != p) {
            p = parent[p];
            color = color == 0 ? 1 : 0;
        }
        return new int[]{p, color};
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();


        for (int[] dislike : dislikes) {
            int p1 = dislike[0];
            int p2 = dislike[1];
            graph.computeIfAbsent(p1, i -> new LinkedList<>());
            graph.computeIfAbsent(p2, i -> new LinkedList<>());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        return graph;
    }

    private boolean dfs(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = buildGraph(dislikes);

        Color[] colorMap = new Color[N + 1];
        for (int i = 1; i <= N; i++) {
            if (colorMap[i] == null && !dfsHelper(graph, i, colorMap, Color.BLUE)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfsHelper(Map<Integer, List<Integer>> graph, int node, Color[] colorMap, Color color) {
        colorMap[node] = color;

        if (graph.containsKey(node)){
            for (Integer child : graph.get(node)) {
                if (colorMap[node] == colorMap[child]) return false;
                if (colorMap[child] == null && !dfsHelper(graph, child, colorMap, color == Color.BLUE ? Color.GREEN : Color.BLUE)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean bfs(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = buildGraph(dislikes);
        Color[] nodeColor = new Color[N + 1];
        boolean[] visited = new boolean[N + 1];
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
