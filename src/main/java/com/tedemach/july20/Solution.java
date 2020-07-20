package com.tedemach.july20;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        head = findNextDifferentNode(head, val);
        ListNode node = head;
        while (node != null) {
            node.next = findNextDifferentNode(node.next, val);
            node = node.next;
        }
        return head;
    }

    private ListNode findNextDifferentNode(ListNode node, int val) {
        while (node != null && node.val == val) {
            node = node.next;
        }
        return node;
    }
}