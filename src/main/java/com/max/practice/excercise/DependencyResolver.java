package com.max.practice.excercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyResolver {

  public List<Integer> topologyOrder(Map<Integer, List<Integer>> map) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    for (Integer module : map.keySet()) {
      if (visited.contains(module)) {
        continue;
      }
      dfs(visited, stack, map, module);

    }
    return new ArrayList<>(stack);
  }

  private void dfs(Set<Integer> visited, ArrayDeque<Integer> stack, Map<Integer, List<Integer>> map, Integer module) {
    visited.add(module);

    for (Integer dependency : map.get(module)) {
      if (visited.contains(dependency)) {
        continue;
      }

      dfs(visited, stack, map, dependency);
    }
    stack.addLast(module);
  }


  public boolean isCyclic(Map<Integer, List<Integer>> map) {
    for (Integer key : map.keySet()) {
      Set<Integer> visited = new HashSet<>();
      if (isCyclic(visited, key, map)) return true;

    }

    return false;
  }

  private boolean isCyclic(Set<Integer> visited, Integer key, Map<Integer, List<Integer>> map) {
    if (visited.contains(key)) return true;
    visited.add(key);
    for (Integer val : map.get(key)) {
      if (isCyclic(visited, val, map)) return true;
    }

    return false;
  }

}
