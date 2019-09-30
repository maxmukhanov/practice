package com.max.practice.excercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new LinkedList<>());
      inDegree.put(i, 0);
    }

    for (int[] req : prerequisites) {
      int one = req[0];
      int two = req[1];

      graph.get(two).add(one);
      inDegree.put(one, inDegree.get(one) + 1);
    }

    Queue<Integer> q = new LinkedList<>();

    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue().equals(0)) {
        q.offer(entry.getKey());
      }
    }

    while (!q.isEmpty()) {
      Integer course = q.poll();

      for (Integer dep : graph.get(course)) {
        int count = inDegree.get(dep);
        count -= 1;

        inDegree.put(dep, count);
        if (count == 0) {
          q.offer(dep);
        }
      }
    }

    for (int count : inDegree.values()) {
      if (count != 0) return false;
    }

    return true;
  }
}
