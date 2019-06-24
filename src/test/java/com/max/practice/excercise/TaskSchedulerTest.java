package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TaskSchedulerTest {
  private TaskScheduler taskScheduler = new TaskScheduler();

  @Test
  public void case1() {
    int actual = taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);

    assertThat(actual).isEqualTo(8);
  }

}