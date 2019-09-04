package com.max.practice.excercise;

import com.max.practice.excercise.partition.HoarePartition;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QuickSort {

  public void sort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(int[] array, int lo, int hi) {
    if (lo >= hi || lo < 0 || hi >= array.length) return;

    int index = HoarePartition.partition(array, lo, hi);

    //Hoare's algo should include pivot. Lomuto's algo should NOT (index - 1)
    sort(array, lo, index);
    sort(array, index + 1, hi);

    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    Map.Entry<Integer, List<Integer>> entry = map.ceilingEntry(1);
    LinkedList<Integer> list = new LinkedList<>();
    list.getLast();
  }

}
