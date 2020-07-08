package com.tedemach.july8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums); // for duplicate
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1])
                i++;
            findTwoSum(nums, target, nums[i], i + 1, sums);
        }
        return sums;
    }

    private void findTwoSum(int[] nums, int target, int currentSum, int index, List<List<Integer>> sums) {
        int leftPtr = index;
        int rightPtr = nums.length - 1;
        int sum = 0;
        while (leftPtr < rightPtr) {
            sum = currentSum + nums[leftPtr] + nums[rightPtr];
            if (sum == target) {
                List<Integer> entry = Arrays.asList(currentSum, nums[leftPtr], nums[rightPtr]);
                sums.add(entry);
                leftPtr++;
                rightPtr--;
                while (leftPtr > 0 && leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr - 1])
                    leftPtr++;
                while (rightPtr < nums.length - 1 && rightPtr > leftPtr && nums[rightPtr] == nums[rightPtr + 1])
                    rightPtr--;
            } else if (sum > target) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }
    }
}