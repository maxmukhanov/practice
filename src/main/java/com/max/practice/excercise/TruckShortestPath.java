package com.max.practice.excercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TruckShortestPath {
  int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {

    Set<Integer> visited = new HashSet<>();

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        if (area.get(i).get(j) == 0) {
          visited.add(index(i, j, numColumns));
        }
      }
    }

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 0));
    visited.add(0);
    while (!q.isEmpty()) {
      Node p = q.poll();

      // Destination found;
      if (area.get(p.row).get(p.col) == 9)
        return p.dist;

      // moving up
      if (p.row - 1 >= 0 && !visited.contains(index(p.row - 1, p.col, numColumns))) {
        q.add(new Node(p.row - 1, p.col, p.dist + 1));
        visited.add(index(p.row - 1, p.col, numColumns));
      }

      // moving down
      if (p.row + 1 < numRows && !visited.contains(index(p.row + 1, p.col, numColumns))) {
        q.add(new Node(p.row + 1, p.col, p.dist + 1));
        visited.add(index(p.row + 1, p.col, numColumns));
      }

      // moving left
      if (p.col - 1 >= 0 && !visited.contains(index(p.row, p.col - 1, numColumns))) {
        q.add(new Node(p.row, p.col - 1, p.dist + 1));
        visited.add(index(p.row, p.col - 1, numColumns));
      }

      // moving right
      if (p.col + 1 < numColumns && !visited.contains(index(p.row, p.col + 1, numColumns))) {
        q.add(new Node(p.row, p.col + 1, p.dist + 1));
        visited.add(index(p.row, p.col + 1, numColumns));
      }
    }
    return -1;
  }

  private int index(int row, int col, int numColumns) {
    return row * numColumns + col;
  }

  static class Node {
    int row;
    int col;
    int dist;

    public Node(int row, int col, int dist) {
      this.row = row;
      this.col = col;
      this.dist = dist;
    }
  }
}
