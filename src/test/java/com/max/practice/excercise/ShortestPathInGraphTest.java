package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShortestPathInGraphTest {
  private ShortestPathInGraph sut = new ShortestPathInGraph();

  @Test
  public void shouldFindShortestDistance() {
    HashMap<String, List<String>> graph = new HashMap<>();
    graph.put("1", Lists.newArrayList("3"));
    graph.put("4", Lists.newArrayList("3", "1"));
    graph.put("5", Lists.newArrayList("4"));
    graph.put("2", Lists.newArrayList("5"));
    assertThat(sut.shortestDistance(graph, "2", "3")).isEqualTo(3);

  }

  @Test
  public void shouldFindShortestPath() {
    HashMap<String, List<String>> graph = new HashMap<>();
    graph.put("1", Lists.newArrayList("3"));
    graph.put("4", Lists.newArrayList("3", "1"));
    graph.put("5", Lists.newArrayList("4"));
    graph.put("2", Lists.newArrayList("5"));
    assertThat(sut.shortestPath(graph, "2", "3")).containsExactly("2", "5", "4", "3");
  }

  @Test
  public void shouldFindShortestPathWithCycle() {
    HashMap<String, List<String>> graph = new HashMap<>();
    graph.put("1", Lists.newArrayList("3"));
    graph.put("4", Lists.newArrayList("3", "1"));
    graph.put("5", Lists.newArrayList("2", "4"));
    graph.put("2", Lists.newArrayList("5"));
    assertThat(sut.shortestPath(graph, "2", "3")).containsExactly("2", "5", "4", "3");
  }
}