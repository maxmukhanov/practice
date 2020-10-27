package com.max.practice.excercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WordBreakHardTest {

    private WordBreakHard sut = new WordBreakHard();

    @Test
    public void test1() {

        List<String> out = sut.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(out);
    }

    @Test
    public void test2() {

        List<String> out = sut.wordBreak("aaaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa"));
        System.out.println(out);
        System.out.println(out.size());
    }
}