package com.tedemach.july17;

import java.util.*;

class Solution {

    private Map<Integer, FrequencyMap> map;
    private int k;

    public int[] topKFrequent(int[] nums, int k) {
        this.k = k;
        map = new HashMap<>();
        mapByFrequency(nums);
        int[] topKFrequentNums = new int[k];
        topKFrequentNums = getTopKFrequentItems();
        return topKFrequentNums;
    }

    private int[] getTopKFrequentItems() {
        PriorityQueue<FrequencyMap> pQueue = new PriorityQueue<>(map.values());
        for (int i = 0; i < map.size() - k; i++) {
            pQueue.poll(); // remove least frequent items
        }
        int[] topKFrequentNums = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequentNums[i] = pQueue.poll().val;
        }
        return topKFrequentNums;
    }

    private void mapByFrequency(int[] nums) {
        FrequencyMap mapper;
        for (int num : nums) {
            mapper = map.getOrDefault(num, new FrequencyMap(num, 0));
            mapper.freq++;
            map.put(num, mapper);
        }
    }

    private class FrequencyMap implements Comparable<FrequencyMap> {
        int val;
        int freq;

        public FrequencyMap(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(FrequencyMap map) {
            return freq - map.freq;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof FrequencyMap))
                return false;
            FrequencyMap map = (FrequencyMap) o;
            return val == map.val;
        }
    }
}

/*
 * 
 * // map (num, freq) HashMap<Integer, FrequencyMap> map = new HashMap<>();
 * FrequencyMap mapper; for (int num : nums) { if (map.containsKey(num)) {
 * mapper = map.get(num); }else { mapper = new FrequencyMap(num, 0); }
 * mapper.freq += 1; map.put(num, mapper); }
 * 
 * 
 * // sort them using freq, then return the array from [last -> last - k] O(n
 * log n) FrequencyMap[] mappedElements = new int[map.size()]; int index = 0;
 * for (FrequencyMap i : map.values()) { mappedElements[index] = i; index++; }
 * Arrays.sort(mappedElements); int [] returnValue = new int[k]; for (int i =
 * mappedElements.length - 1; i >= mappedElements.length - k; i--) {
 * returnValue[mappedElements.length - 1 - i] = mappedElements[i].val; } return
 * returnValue; // return the k most frequent elts
 * 
 * 
 * 
 * 
 * class FrequencyMap implements Comparable<FrequencyMap> { int val; int freq;
 * 
 * public FrequencyMap (int val, int freq) { this.val = val; this.freq = freq; }
 * 
 * @Override public int compareTo (FrequencyMap map) { return freq - map.freq; }
 * 
 * @Override public boolean equals (Object o) { if (o == null || !(o typeof
 * FrequencyMap)) return false; FrequencyMap map = (FrequencyMap)o; return val
 * == map.val; }
 * 
 * @Override public int hashcode () { return Integer.valueOf(val).hashcode() +
 * Integer.valueOf(freq).hashcode(); } }
 * 
 */