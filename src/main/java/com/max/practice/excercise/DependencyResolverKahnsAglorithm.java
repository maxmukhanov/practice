package com.max.practice.excercise;

import java.util.*;

public class DependencyResolverKahnsAglorithm extends DependencyResolver {

  public List<Integer> topologyOrder(Map<Integer, List<Integer>> map) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    for (Integer node : map.keySet()) {
      if (!visited.contains(node)) {
        visit(node, map, visited, deque);
      }
    }

    return new ArrayList<>(deque);
  }

  private void visit(Integer node, Map<Integer, List<Integer>> map, Set<Integer> visited, ArrayDeque<Integer> deque) {
    visited.add(node);

    for (Integer adjacent : map.get(node)) {
      if (visited.contains(adjacent)) {
        continue;
      }
      visit(adjacent, map, visited, deque);
    }

    deque.offerLast(node);

  }


  private List<Integer> khansTopologyOrder(Map<Integer, List<Integer>> map) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    Map<Integer, Integer> inDegreeCount = new HashMap<>();
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      Integer outComingNode = entry.getKey();
      inDegreeCount.putIfAbsent(outComingNode, 0);
      for (Integer node : entry.getValue()) {
        inDegreeCount.putIfAbsent(node, 0);
        inDegreeCount.put(node, inDegreeCount.get(node) + 1);
      }
    }

    LinkedList<Integer> set = new LinkedList<>();
    for (Integer node : inDegreeCount.keySet()) {
      if (inDegreeCount.get(node) == 0) {
        set.add(node);
      }
    }

    while (!set.isEmpty()) {
      Integer n = set.remove(0);
      deque.addFirst(n);
      for (Integer m : map.get(n)) {
        inDegreeCount.put(m, inDegreeCount.get(m) - 1);
        if (inDegreeCount.get(m) == 0) {
          set.add(m);
        }
      }
    }


    return new ArrayList<>(deque);

  }


}
