package com.max.practice.excercise;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {

  /*
   * Key here is to find number of idles
   * */
  public int leastInterval(char[] tasks, int n) {
    int[] counter = new int[26];
    int max = 0;
    int numOfMax = 0;

    for (char task : tasks) {
      counter[task - 'A']++;

      if (max == counter[task - 'A']) {
        numOfMax++;
      } else if (max < counter[task - 'A']){
        max = counter[task - 'A'];
        numOfMax = 1;
      }
    }

    int parts = max - 1;
    int partLength = n - (numOfMax - 1);

    int emptySlots = parts * partLength;
    int availableTasks = tasks.length - max * numOfMax;
    int idles = Math.max(0, emptySlots - availableTasks);


    return tasks.length + idles;
  }
}
