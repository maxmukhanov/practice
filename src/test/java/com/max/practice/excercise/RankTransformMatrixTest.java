package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTransformMatrixTest {

    private RankTransformMatrix sut = new RankTransformMatrix();

    @Test
    public void test1() {
        int[][] actual = sut.matrixRankTransform(new int[][]{{-37, -50, -3, 44}, {-37, 46, 13, -32}, {47, -42, -3, -40}, {-17, -22, -39, 24}});

        assertArrayEquals(new int[][]{{2,1,4,6},{2,6,5,4},{5,2,4,3},{4,3,1,5}}, actual);
    }
}