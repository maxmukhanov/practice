package com.max.practice.excercise;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

  public int oddEvenJumps(int[] A) {
    int count = 1;
    int n = A.length;
    boolean[] lower = new boolean[n];
    boolean[] higher = new boolean[n];
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(A[n - 1], n - 1);
    lower[n - 1] = true;
    higher[n - 1] = true;

    for (int i = n - 2; i >= 0; i--) {

      Map.Entry<Integer, Integer> low = map.floorEntry(A[i]);
      Map.Entry<Integer, Integer> high = map.ceilingEntry(A[i]);

      if (low != null) lower[i] = higher[low.getValue()];
      if (high != null) higher[i] = lower[high.getValue()];

      if (higher[i]) count++;
      map.put(A[i], i);
    }

    return count;
  }

  public int oddEvenJumpsBruteForce(int[] A) {
    int count = 0;

    for (int i = 0; i < A.length; i++) {
      int jumpNum = 1;

      Map<String, Integer> memo = new HashMap<>();
      int fromIndex = i;
      while (true) {
        if (fromIndex == -1) break;
        if (fromIndex == A.length - 1) {
          count++;
          break;
        }
        fromIndex = nextJump(jumpNum, fromIndex, A, memo);
        jumpNum++;
      }
    }

    return count;
  }

  private int nextJump(int jumpNum, int i, int[] A, Map<String, Integer> memo) {
    String key = jumpNum + "_" + i;
    if (memo.containsKey(key)) return memo.get(key);

    int nextInd = -1;
    for (int j = i + 1; j < A.length; j++) {
      if (A[i] >= A[j] && jumpNum % 2 == 0) {
        if (nextInd == -1) nextInd = j;
        else if (A[j] > A[nextInd]) nextInd = j;
      } else if (A[i] <= A[j] && jumpNum % 2 != 0) {
        if (nextInd == -1) nextInd = j;
        else if (A[j] < A[nextInd]) nextInd = j;
      }
    }

    memo.put(key, nextInd);
    return nextInd;
  }
}
