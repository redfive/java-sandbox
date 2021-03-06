package com.jgaunt.java.samples.concurrency;

import com.jgaunt.java.samples.concurrency.IntBuffer;

public class Consumer extends Thread {
    private IntBuffer buffer;

    public Consumer (IntBuffer aBuffer) {
        buffer = aBuffer;
    }

    public void run () {
        while (true) {
            int num = buffer.remove();
            System.out.println("Consumed " + num);
        }
    }
}
