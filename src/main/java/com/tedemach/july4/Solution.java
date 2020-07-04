package com.tedemach.july4;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n must be 1 or above");
        long lastValue = 1;
        n--;
        Queue<Long> queueForTwo = new LinkedList<>();
        Queue<Long> queueForThree = new LinkedList<>();
        Queue<Long> queueForFive = new LinkedList<>();
        queueForTwo.add(2l);
        queueForThree.add(3l);
        queueForFive.add(5l);
        while (n > 0) {
            lastValue = Long.min(queueForTwo.peek(), Long.min(queueForThree.peek(), queueForFive.peek()));
            populateQueues(queueForTwo, queueForThree, queueForFive, lastValue);
            n--;
            System.out.println(lastValue);
        }
        return (int) lastValue;
    }

    private void populateQueues(Queue<Long> queueForTwo, Queue<Long> queueForThree, Queue<Long> queueForFive,
            long lastValue) {
        if (lastValue == queueForTwo.peek()) {
            queueForTwo.remove();
            queueForTwo.add(lastValue * 2);
            queueForThree.add(lastValue * 3);
        } else if (lastValue == queueForThree.peek()) {
            queueForThree.remove();
            queueForThree.add(lastValue * 3);
        } else {
            queueForFive.remove();
        }
        queueForFive.add(lastValue * 5);
    }
}