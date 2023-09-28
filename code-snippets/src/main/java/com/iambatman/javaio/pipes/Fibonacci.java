package com.iambatman.javaio.pipes;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class Fibonacci {

    // Generates Fibonacci numbers using pipes using two
    // threads - a fibonacci writer and a fibonacci reader
    public static void main(String[] args) {

        final int numTerms = 10;
        try {
            // pass either stream to the other to connect
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream  pis = new PipedInputStream(pos);

            // pass the streams to two separate threads
            new Thread(new FibonacciWriter(pos, numTerms)).start();
            new Thread(new FibonacciReader(pis)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
