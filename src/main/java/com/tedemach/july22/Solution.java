package com.tedemach.july22;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * Space efficient solution. However, there is one anti-pattern here! I casted
 * List object to LinkedList object (I know I created the LinkedList object by
 * myself) but is not recommended. I did this to reduce the insertion for odd
 * level nodes into the list from O(n) to O(1)
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(root, 0, result);
        return result;
    }

    private void DFS(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null)
            return;
        if (level == result.size()) {
            result.add(new LinkedList<>()); // add linked list to make it easy
        }
        LinkedList<Integer> list = (LinkedList) result.get(level);
        if (level % 2 == 0) { // even is for forward (left -> right)
            list.add(node.val);
        } else { // odd is for backward (right -> left)
            list.addFirst(node.val);
        }
        DFS(node.left, level + 1, result);
        DFS(node.right, level + 1, result);
    }
}