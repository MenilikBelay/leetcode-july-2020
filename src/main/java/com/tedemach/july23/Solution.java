package com.tedemach.july23;

public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null)
            return null;
        int xor = 0;
        for (int i : nums)
            xor ^= i;
        int diff = xor & -xor; // signifies the 1 that's near to LSB
        int firstValue = 0;
        for (int i : nums) {
            if ((i & diff) != 0) {
                firstValue ^= i;
            }
        }
        return new int[] { firstValue, firstValue ^ xor };
    }
}

/*
 * 
 * [a, b, c, a, b, d] => [c, d]
 * 
 * c ^ d => 1: different (0, 1), 0: similar (0, 0) or (1, 1)
 * 
 * 
 * (a[i] ^ prev) => a[i] OR mix
 * 
 * 
 * 
 * XOR: d/ce = 1, sim = 0
 * 
 * two XOR
 * 
 * 
 * 
 * 
 */