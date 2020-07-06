package com.tedemach.july6;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null)
            return null;
        int carry = 1;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            // I need to have one extra element at first
            int[] solution = new int[digits.length + 1];
            solution[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                solution[i + 1] = digits[i];
            }
            return solution;
        }
        return digits;
    }
}