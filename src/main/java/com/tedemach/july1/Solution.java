package com.tedemach.july1;

public class Solution {
    public int arrangeCoins(int n) {
        if (n < 0)
            throw new IllegalArgumentException("N must be positive");
        double i = (-1.0 + Math.sqrt(1.0 + 8.0 * n)) / 2.0; //
        return (int) i;
    }
}