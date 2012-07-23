package com.jgaunt.java.samples.linkedlist;

public class LinkedListNode {

    private LinkedListNode next;
    private Object data;

    public LinkedListNode( Object aData ) {
        data = aData;
    }

    public Object getData() {
        return data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode aNode) {
        next = aNode;
    }

    public String toString() {
        return data.toString();
    }
}
