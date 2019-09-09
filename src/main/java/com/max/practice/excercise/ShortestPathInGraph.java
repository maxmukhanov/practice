package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInGraph {

  public int shortestDistance(Map<String, List<String>> graph, String source, String destination) {
    List<String> path = shortestPath(graph, source, destination);

    return path.isEmpty() ? -1 : path.size() - 1;
  }

  public List<String> shortestPath(Map<String, List<String>> graph, String source, String destination) {
    LinkedList<String> path = new LinkedList<>();

    Map<String, String> parentMap = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    Set<String> seen = new HashSet<>();
    queue.add(source);
    parentMap.put(source, null);

    while (!queue.isEmpty()) {
      String node = queue.poll();
      if (seen.contains(node)) continue;
      seen.add(node);

      if (destination.equals(node)) {
        while (node != null) {
          path.addFirst(node);
          node = parentMap.get(node);
        }
        return path;
      }

      List<String> outcoming = graph.get(node);
      for (String child : outcoming) {
        if (seen.contains(child)) continue;
        queue.add(child);
        parentMap.put(child, node);
      }
    }

    return path;
  }

}
