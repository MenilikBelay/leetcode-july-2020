package com.tedemach.july19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    
    @Test
    public void addBinaryTest() {
        Solution sol = new Solution();
        assertEquals("0", sol.addBinary("0", "0"));
    }
}