package com.max.practice.excercise.partition;

public class HoarePartition {
  public static int partition(int array[], int low, int hi) {

    int left = low -  1;
    int right = hi + 1;

    int pivot = array[low];

    while (true) {
      //find leftmost element greater or equal than pivot
      do {
        left++;
      } while (array[left] < pivot);

      // find rightmost element less or equal than pivot
      do {
        right--;
      } while (array[right] > pivot);

      if (left >= right) {
        return right;
      }

      swap(array, left, right);
    }


  }

  private static void swap(int[] array, int i, int j) {
    if (i != j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }
}
