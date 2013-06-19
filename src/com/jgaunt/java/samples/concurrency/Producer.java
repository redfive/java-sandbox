package com.jgaunt.java.samples.concurrency;

import com.jgaunt.java.samples.concurrency.IntBuffer;
import java.util.Random;

public class Producer extends Thread {

    private IntBuffer buffer;

    public Producer (IntBuffer aBuffer) {
        buffer = aBuffer;
    }

    public void run () {
        Random r = new Random();

        while (true) {
            int num = r.nextInt();
            System.out.println("Producing " + num);
            buffer.add(num);
        }
    }

}
