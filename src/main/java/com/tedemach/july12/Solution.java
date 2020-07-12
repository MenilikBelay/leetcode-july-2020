package com.tedemach.july12;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversedValue = 0;
        int index = 0;
        while (index < 32 && n != 0) {
            reversedValue = reversedValue << 1; // make a room for last bit
            reversedValue += (n & 1); // append last bit
            n = n >>> 1; // move to next bit
            index++;
        }
        if (index != 32) {
            // do something
            reversedValue = reversedValue << (32 - index);
        }
        return reversedValue;
    }
}