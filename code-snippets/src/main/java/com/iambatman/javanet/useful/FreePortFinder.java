package com.iambatman.javanet.useful;

import java.io.IOException;
import java.net.ServerSocket;

public class FreePortFinder {

    /**
     * Returns a free port number on localhost.
     * <p>
     * Heavily inspired from org.eclipse.jdt.launching.SocketUtil (to avoid a dependency to JDT just because of this).
     * Slightly improved with close() missing in JDT. And throws exception instead of returning -1.
     *
     * @return a free port number on localhost
     * @throws IllegalStateException if unable to find a free port
     */
    static int findFreePort() {
        ServerSocket socket = null;

        try {
            socket = new ServerSocket(0);
            socket.setReuseAddress(true);

            int port = socket.getLocalPort();

            try {
                socket.close();
            } catch (IOException e) {
                // Ignore IOException on close()
            }
            return port;

        } catch (IOException e) {
            // handle error
        } finally {
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    // handle error
                }
            }
        }

        throw new IllegalStateException("Could not find a free TCP/IP port to start embedded Jetty HTTP Server on");
    }
}
