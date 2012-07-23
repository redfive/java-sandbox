package com.jgaunt.java.samples.concurrency;

public class IntBuffer {
    private int index = 0;
    private int [] buffer = new int[8];

    public synchronized void add ( int aNum ) {
        /* wait for a notify when the buffer is full */
        while ( index == (buffer.length) ) {
            try {
                wait();
            } catch (InterruptedException e) {
                // No-Op
            }
        }
        buffer[index++] = aNum;
        notifyAll();
    }

    public synchronized int remove () {
        /* wait for a notify when the buffer is empty */
        while ( index == 0 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                // No-Op
            }
        }
        int num = buffer[--index];
        notifyAll();
        return num;
    }
}
