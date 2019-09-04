package com.max.practice.excercise;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class PrevPermutationWithOneSwap {
  public int[] prevPermOpt1(int[] A) {
    if (A == null || A.length <= 1) return A;

    TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
    int minDist = Integer.MAX_VALUE;
    int startInx = -1;

    for(int i = 0; i < A.length; i++) {
      LinkedList<Integer> list = map.get(A[i]);
      if (list == null) {
        list = new LinkedList<>();
        map.put(A[i], list);
      }
      list.add(i);
    }

    for (int i = A.length - 1; i > 0; i--) {
      int cur = A[i];

      Map.Entry<Integer, LinkedList<Integer>> entry = map.ceilingEntry(cur + 1);

      if (entry != null) {
        LinkedList<Integer> list = entry.getValue();
        int closestIndex = list.getLast();
        if (i - closestIndex < minDist) {
          minDist = i - closestIndex;
          startInx = i;
        }

      }

      LinkedList<Integer> value = map.get(cur);
      value.removeLast();
      if (value.isEmpty()) map.remove(cur);
    }

    if (startInx != -1) {
      int temp = A[startInx];
      A[startInx] = A[startInx - minDist];
      A[startInx - minDist] = temp;
    }

    return A;
  }
}
