package com.tedemach.july16;

class Solution {
    public double myPow(double x, int n) {
        if (n < 0)
            return multiplyNTimes(1 / x, -n);
        return multiplyNTimes(x, n);
    }

    private double multiplyNTimes(double x, long n) {
        if (n == 0)
            return 1.0;
        else if (n == 1)
            return x;
        double product = multiplyNTimes(x, n / 2);
        return product * product * (n % 2 == 0 ? 1 : x);
    }
}