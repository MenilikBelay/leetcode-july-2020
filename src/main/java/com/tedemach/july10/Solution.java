package com.tedemach.july10;

class Solution {
    Node flattenedList;

    public Node flatten(Node head) {
        if (head == null)
            return head;
        flattenedList = new Node();
        Node node = flattenedList;
        visitNode(head);
        node = node.next;
        node.prev = null;
        return node;
    }

    public void visitNode(Node node) {
        if (node == null)
            return;
        copyAndAppendNode(node);
        flattenedList = flattenedList.next;
        visitNode(node.child);
        visitNode(node.next);
    }

    private void copyAndAppendNode(Node node) {
        Node newNode = new Node();
        newNode.val = node.val;
        flattenedList.next = newNode;
        newNode.prev = flattenedList;
    }
}

/*
 * 
 * Naive soln
 * 
 * if (node == null) return; if (visisted) return; flattenedList.next = new
 * Node(node.val); recurse(node.child); recurse(node.next);
 * 
 * 
 * 
 * 
 */