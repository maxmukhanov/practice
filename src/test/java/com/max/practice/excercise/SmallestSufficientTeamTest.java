package com.max.practice.excercise;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SmallestSufficientTeamTest {
    SmallestSufficientTeam sut = new SmallestSufficientTeam();

    @Test
    public void test1() {
        int[] actual = sut.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                Arrays.asList(
                        Arrays.asList("java"),
                        Arrays.asList("nodejs"),
                        Arrays.asList("nodejs", "reactjs")));

        assertArrayEquals(new int[]{0, 2}, actual);
    }

    @Test
    public void test2() {
        int[] actual = sut.smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"},
                Arrays.asList(Arrays.asList("algorithms", "math", "java"),
                        Arrays.asList("algorithms", "math", "reactjs"),
                        Arrays.asList("java", "csharp", "aws"),
                        Arrays.asList("reactjs", "csharp"),
                        Arrays.asList("csharp", "math"),
                        Arrays.asList("aws", "java")));

        assertArrayEquals(new int[]{1, 2}, actual);
    }


}