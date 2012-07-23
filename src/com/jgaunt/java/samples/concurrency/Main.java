package com.jgaunt.java.samples.concurrency;

import com.jgaunt.java.samples.concurrency.IntBuffer;
import com.jgaunt.java.samples.concurrency.Producer;
import com.jgaunt.java.samples.concurrency.Consumer;

public class Main {
    public static void main (String [] args) {
        IntBuffer buffer = new IntBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        consumer.start();
        producer.start();
    }
}
