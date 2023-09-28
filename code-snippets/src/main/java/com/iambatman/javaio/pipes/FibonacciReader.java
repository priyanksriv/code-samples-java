package com.iambatman.javaio.pipes;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class FibonacciReader implements Runnable {

    private final DataInputStream dis;

    // Wrapping the piped-stream in DataInputStream for
    // formatting bytes as integers
    public FibonacciReader(InputStream is) {
        this.dis = new DataInputStream(is);
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print(dis.readInt() + " ");
            }
        } catch (IOException e) {
            System.out.println("Done!");
        }
    }
}
