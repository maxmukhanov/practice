package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BoxSortingTest {

  private BoxSorting boxSorting = new BoxSorting();

  @Test
  public void case1() {
    List<String> strings = boxSorting.orderedJunctionBoxes(0, Lists.newArrayList(
        "ykc 82 01",
        "eo fist",
        "09z cat h",
        "06f 12 23",
        "az0 fist",
        "236 cat dog ra"
    ));

    assertThat(strings).containsExactly(
        "236 cat dog ra",
        "09z cat h",
        "az0 fist",
        "eo fist",
        "ykc 82 01",
        "06f 12 23"
    );
  }
}