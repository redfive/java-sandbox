package com.jgaunt.java.samples.linkedlist;

import com.jgaunt.java.samples.linkedlist.LinkedListNode;


/**
  * A linked list implementation that stores opaque Objects as a
  *   data member. 
  */
public class LinkedList {
    LinkedListNode head = null;

    public LinkedList () {
    }

    public LinkedList (Object aData) {
        head = new LinkedListNode(aData);
    }

    public LinkedListNode find (Object aData) throws LinkedListException {
        LinkedListNode curNode = head;
        while (curNode != null && curNode.getData() != aData) {
            curNode = curNode.getNext();
        }
        if (curNode == null) {
            throw new LinkedListException("LinkedList Exception: Data not in list");
        }
        return curNode;
    }

    public boolean insertBefore (LinkedListNode aNode, Object aData) {
         // create the node to insert
         LinkedListNode newNode = new LinkedListNode(aData);

         // Special case the head node and null node
         if (aNode == head || aNode == null) {
             newNode.setNext(head);
             head = newNode;
             return true;
         }

         // It wasn't head, start on the next node
         LinkedListNode curNode = head;
         while ((curNode != null) && (curNode.getNext() != aNode)) {
             curNode = curNode.getNext();
         }

         // found the node; curNode.next is the node to insert in front of
         if (curNode != null) {
             newNode.setNext(curNode.getNext());
             curNode.setNext(newNode); 
             return true;
         } 

         // TODO: throw an exception
         return false;
    }

    public void remove (LinkedListNode aNode) {
    }

    public String toString () {
        LinkedListNode node = head;
        String outputString = "";
        while (node != null) {
            outputString += node.toString() + "-->";
            node = node.getNext();
        }
        outputString += "null";
        return outputString;
    }
}

