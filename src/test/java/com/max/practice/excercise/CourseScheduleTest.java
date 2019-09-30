package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CourseScheduleTest {

  private CourseSchedule sut = new CourseSchedule();

  @Test
  public void shouldReturnTrueWhenCanFinish() {
    assertThat(sut.canFinish(3, new int[][]{{1, 0}, {0, 2}})).isTrue();
  }

  @Test
  public void shouldReturnFalseWhenCanNotFinish() {
    assertThat(sut.canFinish(2, new int[][]{{1, 0}, {0, 1}})).isFalse();
  }
}