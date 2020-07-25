package com.tedemach.july25;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("Null or empty array");
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start >= end)
            return nums[start];
        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[start])
            return findMin(nums, start + 1, mid);
        else if (nums[mid] > nums[end])
            return findMin(nums, mid + 1, end);
        int left = findMin(nums, start, mid - 1);
        int right = findMin(nums, mid, end - 1);
        return left < right ? left : right;
    }
}

/**
 * Runtime complexity: In best case, it will take O(log n) time. However, in
 * cases where plenty of duplicates are there, it might take O(n) time [worst
 * case].
 */