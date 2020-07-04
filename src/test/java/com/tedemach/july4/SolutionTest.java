package com.tedemach.july4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void nthUglyNumberTest() {
        Solution solution = new Solution();
        assertEquals(5832, solution.nthUglyNumber(150), "N = 150, NthUglyNumber: 5832");
        assertEquals(24, solution.nthUglyNumber(15), "N = 15, NthUglyNumber: 24");
        assertEquals(1399680000, solution.nthUglyNumber(1600), "N = 1600, NthUglyNumber: 1399680000");
    }
}