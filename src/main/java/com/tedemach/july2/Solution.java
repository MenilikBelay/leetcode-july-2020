package com.tedemach.july2;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<ValueLevelMap> queue = new LinkedList<>();
        populateQueue(queue, root, 0);
        List<List<Integer>> retVal = new LinkedList<>();
        int lastLevel = -1;
        while (!(queue.isEmpty())) {
            ValueLevelMap vlm = queue.remove();
            populateQueue(queue, vlm.node.right, vlm.level + 1);
            populateQueue(queue, vlm.node.left, vlm.level + 1);
            lastLevel = write(retVal, vlm, lastLevel);
        }
        return retVal;
    }

    private void populateQueue(Queue<ValueLevelMap> queue, TreeNode node, int level) {
        if (node == null)
            return;
        ValueLevelMap vlm = new ValueLevelMap(node, level);
        queue.add(vlm);
    }

    private int write(List<List<Integer>> writeTo, ValueLevelMap vlm, int lastLevel) {
        List<Integer> value = null;
        int level = lastLevel;
        if (vlm.level > lastLevel) {
            value = new LinkedList<>();
            writeTo.add(0, value);
            level = vlm.level;
        } else {
            value = writeTo.get(0);
        }
        value.add(0, vlm.node.val);
        return level;
    }

    private class ValueLevelMap {
        TreeNode node;
        int level;

        ValueLevelMap(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}