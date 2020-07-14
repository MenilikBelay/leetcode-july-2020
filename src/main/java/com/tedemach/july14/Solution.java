package com.tedemach.july14;

public class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = ((hour * 30) + getFiveDigitPrecision(getOffsetAngle(minutes))) % 360;
        double minuteAngle = minutes * 6;
        double difference = Math.abs(hourAngle - minuteAngle);
        return Double.min(360 - difference, difference);
    }

    private double getOffsetAngle(int minutes) {
        if (minutes == 0)
            return 0;
        return (30.0 / (60.0 / minutes));
    }

    private double getFiveDigitPrecision(double num) {
        int convertedNum = (int) (num * 100000);
        return convertedNum / 100000.0;
    }
}

/*
 * 
 * hr: angle = ((hour * 30) + getOffsetAngle(min)) % 360 12: 360, 0 ;;; 1: 30
 * ;;; 2: 60 .... 11: 330
 * 
 * min: angle = min * 6 0: 360, 0 ;;; 1: 6 ;;; 2: 12 .... 59: 354
 * 
 * getOffsetAngle(min) if (min == 0) return 0; return (30 / (60/min));
 * 
 * 
 * 
 */