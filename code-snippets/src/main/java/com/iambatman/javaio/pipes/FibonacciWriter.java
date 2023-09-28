package com.iambatman.javaio.pipes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;


final class FibonacciWriter implements Runnable {

    private final DataOutputStream dos;
    private final int numTerms;

    // Wrapping the piped-stream in DataOutputStream for
    // formatting bytes as integers
    public FibonacciWriter(OutputStream os, int numTerms) {
        this.dos = new DataOutputStream(os);
        if (numTerms > 99) {
            throw new IllegalArgumentException("Max num terms <= 99");
        }
        this.numTerms = numTerms;
    }

    @Override
    public void run() {
        int f1 = 1, f2 = 1;
        try {
            dos.writeInt(f1);
            dos.writeInt(f2);

            for (int i = 2; i <= numTerms; i++) {
                int t = f2;
                f2 = t + f1;
                f1 = t;
                dos.writeInt(f2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
