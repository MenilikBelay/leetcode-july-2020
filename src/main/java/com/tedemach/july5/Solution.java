package com.tedemach.july5;

public class Solution {
    public int hammingDistance(int x, int y) {
        // perform XOR
        int difference = x ^ y;
        // count the number of 1s (iterate 32 times to represent the int or only check
        // until difference gets to zero)
        int hummingDistance = 0;
        while (difference != 0) {
            hummingDistance += difference & 1; // mask the first 31 bits; only check the LSB
            difference = difference >>> 1; // for next round
        }
        return hummingDistance;
    }
}