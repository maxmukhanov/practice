package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class DependencyResolverTest {
  private DependencyResolver dependencyResolver = new DependencyResolver();

  @Test
  public void shouldDoTopologyOrder() {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    map.put(1, Lists.newArrayList());
    map.put(2, Lists.newArrayList(1));
    map.put(3, Lists.newArrayList(1, 2));
    List<Integer> actual = dependencyResolver.topologyOrder(map);

    assertThat(actual).containsExactly(1, 2, 3);
  }

  @Test
  public void shouldReturnTrueWhenGraphIsCyclic() {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    map.put(1, Lists.newArrayList(2, 4));
    map.put(2, Lists.newArrayList(3));
    map.put(3, Lists.newArrayList(1));
    map.put(4, Lists.newArrayList());

    assertThat(dependencyResolver.isCyclic(map)).isTrue();
  }

  @Test
  public void shouldReturnFalseWhenGraphIsACyclic() {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    map.put(1, Lists.newArrayList(4));
    map.put(2, Lists.newArrayList(3));
    map.put(3, Lists.newArrayList(1));
    map.put(4, Lists.newArrayList());

    assertThat(dependencyResolver.isCyclic(map)).isFalse();
  }
}