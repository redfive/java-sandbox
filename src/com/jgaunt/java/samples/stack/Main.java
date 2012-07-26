package com.jgaunt.java.samples.stack;

import com.jgaunt.java.samples.stack.Stack;

public class Main {
    public static void main (String [] args) {
        Stack testStack = new Stack();
        testStack.push("foo");
        testStack.push("bar");
        testStack.push("baz");
        System.out.println( testStack);
        testStack.pop();
        System.out.println( testStack);
    }
}
