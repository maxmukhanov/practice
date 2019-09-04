package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QuickSortTest {

  private QuickSort quickSort = new QuickSort();

  @Test
  public void shouldSort() {
    int[] array = {3,3,1,1, 5, 3, 6, 2, 4};
    quickSort.sort(array);

    assertThat(array).isSorted();
  }

  @Test
  public void shouldSort2() {
    int[] array = {5, 3, 6, 2, 4};
    quickSort.sort(array);

    assertThat(array).isSorted();
  }
}