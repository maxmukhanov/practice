package com.max.practice.excercise;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
  private int capacity;
  private HashMap<Integer, Integer> values;
  private HashMap<Integer, Integer> counts;
  private HashMap<Integer, LinkedHashSet<Integer>> lists;

  private int min = -1;
  public LFUCache(int capacity) {
    this.capacity = capacity;
    values = new HashMap<>();
    counts = new HashMap<>();
    lists = new HashMap<>();
    lists.put(1, new LinkedHashSet<>());
  }

  public int get(int key) {
    if (values.containsKey(key)) {
      Integer count = counts.get(key);

      LinkedHashSet<Integer> keys = lists.getOrDefault(count, new LinkedHashSet<>());
      keys.remove(key);

      if (min == count && keys.isEmpty()) min++;
      counts.put(key, count + 1);
      keys = lists.getOrDefault(count + 1, new LinkedHashSet<>());
      keys.add(key);
      lists.put(count + 1, keys);

      return values.get(key);
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (capacity <= 0) return;

    if (values.containsKey(key)) {
      values.put(key, value);//replace value
      get(key);
    } else {
      if (capacity <= values.size()) {
        evict();
      }

      values.put(key, value);
      counts.put(key, 1);
      min = 1;
      lists.get(1).add(key);
    }
  }

  private void evict() {
    LinkedHashSet<Integer> keys = lists.get(min);
    Integer keyToEvict = keys.iterator().next();
    keys.remove(keyToEvict);
    if (keys.isEmpty()) min = 1;
    values.remove(keyToEvict);
    counts.remove(keyToEvict);
  }
}