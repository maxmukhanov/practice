package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MathExpressionEvaluatorTest {
    private MathExpressionEvaluator evaluator = new MathExpressionEvaluator();

    @Test
    public void shouldEval() {
        assertThat(evaluator.eval("1+2*3")).isEqualTo(7);
        assertThat(evaluator.eval("1*2+3")).isEqualTo(5);
        assertThat(evaluator.eval("2*(2+3)")).isEqualTo(10);
    }

    @Test
    public void case2() {
        assertThat(evaluator.eval("1+(2^(8-2*3) / 2) * 5 - 8/2 + 7")).isEqualTo(14);

    }
}