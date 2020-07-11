package com.tedemach.july11;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return null;
        List<List<Integer>> powerset = new ArrayList<>();
        powerset.add(new ArrayList<>()); // add empty set
        for (int i = 0; i < nums.length; i++) {
            int currentIndex = powerset.size();
            for (int j = 0; j < currentIndex; j++) {
                List<Integer> set = new ArrayList<>(powerset.get(j)); // copy
                set.add(nums[i]);
                powerset.add(set);
            }
        }
        return powerset;
    }
}