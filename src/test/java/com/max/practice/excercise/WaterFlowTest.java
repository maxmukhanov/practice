package com.max.practice.excercise;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class WaterFlowTest {
    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());

        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return list.stream().reduce((x, y) -> "0".equals(x) ? y : x + y).get();
    }



    @Test
    public void name() {
        WaterFlow waterFlow = new WaterFlow();

        int[][] data = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        List<List<Integer>> lists = waterFlow.pacificAtlantic(data);

        System.out.println(lists);
    }

    @Test
    public void hashCodeOfList() {
        int i = 'a' - 'a';
        System.out.println(i);
        i = 'a' - 'b';
        System.out.println(i);

    }
}