package com.max.practice.excercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
  public String alienOrder(String[] words) {
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> inDegree = new HashMap<>();

    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (!graph.containsKey(ch)) graph.put(ch, new LinkedList<>());
        if (!inDegree.containsKey(ch)) inDegree.put(ch, 0);
      }
    }

    for (int i = 1; i < words.length; i++) {
      int j = 0;
      while (j < words[i - 1].length() && j < words[i].length()) {
        char ch1 = words[i - 1].charAt(j);
        char ch2 = words[i].charAt(j);

        if (ch1 != ch2) {
          graph.get(ch1).add(ch2);
          inDegree.put(ch2, inDegree.get(ch2) + 1);
          break;
        }

        j++;
      }
    }

    //do topological sort
    bfs(graph, inDegree, sb);

    for (Integer value : inDegree.values()) {
      if (value != 0) return "";
    }
    return sb.toString();
  }

  private void bfs(Map<Character, List<Character>> graph, Map<Character, Integer> inDegree, StringBuilder sb) {

    Queue<Character> queue = new LinkedList<>();

    for (Character ch : inDegree.keySet()) {
      if (inDegree.get(ch) == 0) queue.add(ch);
    }

    while (!queue.isEmpty()) {
      Character ch = queue.poll();

      sb.append(ch);
      List<Character> incoming = graph.get(ch);
      for (Character in : incoming) {
        inDegree.put(in, inDegree.get(in) - 1);

        if (inDegree.get(in) == 0) {
          queue.add(in);
        }
      }
    }
  }

}
