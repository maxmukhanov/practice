package com.max.practice.excercise;

import java.util.*;

//https://leetcode.com/problems/rank-transform-of-a-matrix/
public class RankTransformMatrix {

    //time O(nmlog(nm)) (tree map(sorting) + amortized union find). space O(nm)
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = matrix[i][j];
                List<int[]> list = map.getOrDefault(val, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(val, list);
            }
        }

        int[] rowRanks = new int[n];
        int[] colRanks = new int[n];
        for (int i = 0; i < n; i++) rowRanks[i] = 1;
        for (int j = 0; j < m; j++) colRanks[j] = 1;


        for (Integer key : map.keySet()) {
            List<int[]> list = map.get(key);
            int size = list.size();

            int[] parent = new int[size];
            for (int k = 0; k < size; k++) parent[k] = k;

            //Union connected components
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int [] a = list.get(i);
                    int[] b = list.get(j);
                    if (a[0] == b[0] || a[1] == b[1]){
                        union(i, j, parent);
                    }
                }
            }

            Map<Integer, List<int[]>> allUnions = new HashMap<>();
            for (int k = 0; k < size; k++) {
                int parentKey = find(k, parent);
                List<int[]> unions = allUnions.getOrDefault(parentKey, new ArrayList<>());
                unions.add(list.get(k));
                allUnions.put(parentKey, unions);
            }

            //Let's find max rank for all joined components
            for (List<int[]> unions : allUnions.values()) {
                int max = 0;
                for (int[] union : unions) {
                    max = Math.max(max, Math.max(rowRanks[union[0]], colRanks[union[1]]));
                }

                for (int[] union : unions) {
                    ans[union[0]][union[1]] = max;
                    rowRanks[union[0]] = max + 1;
                    colRanks[union[1]] = max + 1;
                }
            }

        }

        return ans;
    }

    private void union(int i, int j, int[] parent) {
        parent[find(i, parent)] = find(j, parent);
    }

    private int find(int a, int[] parent) {
        if (parent[a] != a) {
            parent[a] = find(parent[a], parent);
        }

        return parent[a];
    }

    //time O(nmlog(nm) (sorting), space O(nm). this approach performs way more better and the above
    public int[][] matrixRankTransform1(int[][] a) {
        int n = a.length, m = a[0].length;
        int[][] ai = new int[n*m][];
        int p = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                ai[p++] = new int[]{a[i][j], i, j};
            }
        }
        Arrays.sort(ai, Comparator.comparingInt(x -> x[0]));
        int[] rr = new int[n];
        int[] cr = new int[m];

        int[][] ans = new int[n][m];
        for(int i = 0;i < ai.length;){
            int j = i;
            while(j < ai.length && ai[j][0] == ai[i][0])j++;

            for(int k = i;k < j;k++) {
                int[] e = ai[k];
                int rank = 0;
                rank = Math.max(rank, rr[e[1]] + 1);
                rank = Math.max(rank, cr[e[2]] + 1);
                ans[e[1]][e[2]] = rank;
            }

            while(true) {
                for (int k = i; k < j; k++) {
                    int[] e = ai[k];
                    int rank = ans[e[1]][e[2]];
                    rr[e[1]] = Math.max(rr[e[1]], rank);
                    cr[e[2]] = Math.max(cr[e[2]], rank);
                }

                boolean ch = false;
                for (int k = i; k < j; k++) {
                    int[] e = ai[k];
                    if (rr[e[1]] > ans[e[1]][e[2]] || cr[e[2]] > ans[e[1]][e[2]]) {
                        ans[e[1]][e[2]] = Math.max(rr[e[1]], cr[e[2]]);
                        ch = true;
                    }
                }
                if(!ch)break;
            }

            i = j;
        }
        return ans;
    }
}
