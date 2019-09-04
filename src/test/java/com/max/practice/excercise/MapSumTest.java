package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MapSumTest {
  private MapSum mapSum = new MapSum();


  @Test
  public void case1() {
//    ["MapSum"
//"insert"
//"sum"
//"insert"
//"sum"]
//[[]
//["a",3]
//["ap"]
//["b",2]
//["a"]]

    mapSum.insert("apple", 3);
    assertThat(mapSum.sum("apple")).isEqualTo(3);
  }
}