package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NQueensTest {
    private NQueens sut = new NQueens();

    @Test
    public void test1() {
        List<List<String>> actual = sut.solveNQueens(4);

        for (List<String> board : actual) {
            for (String s : board) {
                System.out.println(s);
            }
            System.out.println("-------------------");
        }

        assertThat(actual, Matchers.contains(
                Lists.newArrayList(".Q..","...Q","Q...","..Q."),
                Lists.newArrayList("..Q.","Q...","...Q",".Q..")));
    }
}