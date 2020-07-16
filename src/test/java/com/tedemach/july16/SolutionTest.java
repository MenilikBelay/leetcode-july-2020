package com.tedemach.july16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void powTest() {
        Solution sol = new Solution();
        assertEquals(0, sol.myPow(2.00000, (-2147483648)));
    }
}