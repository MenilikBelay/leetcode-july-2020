package com.tedemach.july27;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int[] inorder;
    private int[] postorder;
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        this.inorder = inorder;
        this.postorder = postorder;
        inorderIndex = new HashMap<>();
        populateIndex();
        postorderIndex = postorder.length - 1;
        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end || postorderIndex < 0 || end > inorder.length - 1)
            return null;
        TreeNode node = new TreeNode(postorder[postorderIndex]);
        int currentInorderIndex = findIndex(postorder[postorderIndex]);
        postorderIndex--; // decrement postorderIndex
        node.right = buildTree(currentInorderIndex + 1, end);
        node.left = buildTree(start, currentInorderIndex - 1);
        return node;
    }

    private int findIndex(int value) {
        return inorderIndex.get(value);
    }

    private void populateIndex() {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
    }
}

/*


*/