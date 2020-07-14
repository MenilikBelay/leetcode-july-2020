package com.tedemach.july13;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null || (p.val != q.val))
            return false;
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
        while (!(pQueue.isEmpty()) && !(qQueue.isEmpty())) {
            p = pQueue.remove();
            q = qQueue.remove();
            if (check(p.left, q.left) && check(p.right, q.right)) {
                if (p.left != null) {
                    pQueue.add(p.left);
                    qQueue.add(q.left);
                }
                if (q.right != null) {
                    pQueue.add(p.right);
                    qQueue.add(q.right);
                }
            } else {
                return false; // mismatch
            }
        }
        return (pQueue.isEmpty() && qQueue.isEmpty());
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        return p.val == q.val;
    }
}