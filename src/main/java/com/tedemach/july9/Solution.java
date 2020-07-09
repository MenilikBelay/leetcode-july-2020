package com.tedemach.july9;

import java.util.HashMap;

class Solution {
    int maxWidth;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        maxWidth = 0;
        HashMap<Integer, Integer> leftDepth = new HashMap<>();
        calculateMaxWidth(root, 0, 0, leftDepth);
        return maxWidth;
    }

    private void calculateMaxWidth(TreeNode node, int level, int position, HashMap<Integer, Integer> leftDepth) {
        if (node == null)
            return;
        leftDepth.computeIfAbsent(level, k -> position); // first position from left side
        maxWidth = Integer.max(maxWidth, position - leftDepth.get(level) + 1);
        // recurse [get left and right childs by node*2 + 1 and node*2 + 2]
        calculateMaxWidth(node.left, level + 1, position * 2 + 1, leftDepth);
        calculateMaxWidth(node.right, level + 1, position * 2 + 2, leftDepth);
    }
}