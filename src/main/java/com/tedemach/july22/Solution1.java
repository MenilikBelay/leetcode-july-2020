package com.tedemach.july22;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * This solution has space complexity of O(n) besides a running time complexity
 * of O(n), where n is the number of elements in the tree
 */
public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Stack<TreeNode> forwardCache = new Stack<>();
        Stack<TreeNode> backwardCache = new Stack<>();
        boolean goForward = true;
        forwardCache.add(root);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // for the head
        while (!forwardCache.isEmpty() || !backwardCache.isEmpty()) {
            boolean prevDrxn = goForward;
            goForward = goForward ? !forwardCache.isEmpty() : backwardCache.isEmpty();
            TreeNode node;
            if (goForward) {
                node = forwardCache.pop();
                populateCache(node, backwardCache, true);
            } else {
                node = backwardCache.pop();
                populateCache(node, forwardCache, false);
            }
            appendNode(node, result, prevDrxn != goForward);
        }
        return result;
    }

    private void populateCache(TreeNode node, Stack<TreeNode> cache, boolean leftToRight) {
        if (leftToRight) {
            if (node.left != null)
                cache.add(node.left);
            if (node.right != null)
                cache.add(node.right);
        } else {
            if (node.right != null)
                cache.add(node.right);
            if (node.left != null)
                cache.add(node.left);
        }
    }

    private void appendNode(TreeNode node, List<List<Integer>> result, boolean inNewList) {
        if (!inNewList) {
            result.get(result.size() - 1).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            result.add(list);
        }
    }
}