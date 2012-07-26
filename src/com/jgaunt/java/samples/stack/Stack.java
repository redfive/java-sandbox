package com.jgaunt.java.samples.stack;

import com.jgaunt.java.samples.linkedlist.LinkedList;
import com.jgaunt.java.samples.linkedlist.LinkedListNode;

public class Stack extends LinkedList {
    public Object pop () {
        if (head == null) {
            return null;
        }
        Object retObject = head.getData();
        head = head.getNext();
        return retObject;
    }

    public void push (Object aData) {
        if (head == null) {
            head = new LinkedListNode(aData);
        } else {
            insertBefore(head, aData);
        }
    }
}
