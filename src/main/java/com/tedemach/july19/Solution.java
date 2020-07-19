package com.tedemach.july19;

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return null;
        String longerString = a.length() > b.length() ? a : b;
        String shorterString = a.length() > b.length() ? b : a;
        int longerStringLength = longerString.length();
        int shorterStringLength = shorterString.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shorterStringLength; i++) {
            carry = sumBinaryAndReturnCarry(shorterString.charAt(shorterStringLength - 1 - i) - '0',
                    longerString.charAt(longerStringLength - 1 - i) - '0', carry, sb);
        }
        for (int i = longerStringLength - shorterStringLength - 1; i >= 0; i--) {
            carry = sumBinaryAndReturnCarry(0, longerString.charAt(i) - '0', carry, sb);
        }
        if (carry > 0) {
            carry = sumBinaryAndReturnCarry(0, 0, carry, sb);
        }
        return sb.reverse().toString();
    }

    private int sumBinaryAndReturnCarry(int x, int y, int carry, StringBuilder storage) {
        int sum = x + y + carry;
        storage.append(sum % 2);
        return sum / 2;
    }
}

/*
 * 
 * ls = "0" ss = "0" c = 0, 0 sb = '0' i = 0
 * 
 * "111111" "100" 1000011
 * 
 * carry
 * 
 * // until the shorter ends
 * 
 * 
 * // until the longer ends (remaining)
 * 
 * 
 * // if any carry overs
 * 
 * // append into string builder // return the reversed string builder
 * 
 * StringBuilder sb = new StringBuilder();
 * 
 * 
 * private int sum (StringBuilder sb, int x, int y, int carry) { int sum = x + y
 * + carry; sb.append(sum % 2); return sum / 2; }
 * 
 * 
 * 
 * 
 */