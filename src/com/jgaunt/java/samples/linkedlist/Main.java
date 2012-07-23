package com.jgaunt.java.samples.linkedlist;

import com.jgaunt.java.samples.linkedlist.LinkedListNode;
import com.jgaunt.java.samples.linkedlist.LinkedList;

public class Main {
    public static void main (String args []) {
        LinkedList oneList = new LinkedList("one");

        // should push to the "top" of the list
        oneList.insertBefore(null, "four");

        // use find to get a node
        LinkedListNode node = null;
        try {
            node = oneList.find("one");
        } catch (LinkedListException e) {
            System.out.println(e);
        }
        // add a node before an existing node
        oneList.insertBefore(node, "two");

        // look for a non-existing node
        try {
            node = oneList.find("three");
        } catch (LinkedListException e) {
            System.out.println(e);
            // Add it in the exception handling
            oneList.insertBefore(null, "three");
        }

        // printing the list will output a representation of the nodes, in order.
        System.out.println(oneList);
        
    }
}
