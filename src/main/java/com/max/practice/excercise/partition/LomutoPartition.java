package com.max.practice.excercise.partition;

public class LomutoPartition {

  public static int partition(int array[], int low, int hi) {
    int pivot = array[hi];

    int i = low - 1;
    int j = low;

    while (j < hi) {
      if (array[j] < pivot) {
        i++;
        swap(array, i, j);
      }
      j++;
    }

    swap(array, ++i,  j);
    return i;
  }

  private static void swap(int[] array, int i, int j) {
    if (i != j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }
}
