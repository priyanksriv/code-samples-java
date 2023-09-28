package com.iambatman.javanet.debug;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectTimeoutTest {

    private ServerSocket serverSocket;

    private int port;

    @BeforeAll
    public void beforeClass() throws IOException {
        //server socket with single element backlog queue (1) and dynamicaly allocated port (0)
        serverSocket = new ServerSocket(0, 1);
        //just get the allocated port
        port = serverSocket.getLocalPort();
        //fill backlog queue by this request so consequent requests will be blocked
        new Socket().connect(serverSocket.getLocalSocketAddress());
    }

    @AfterAll
    public void afterClass() throws IOException {
        //some cleanup
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    }

    @Test
    public void testConnect() throws IOException {
        URL url = new URL("http://localhost:" + port); //use allocated port
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(1000);
        //connection.setReadTimeout(2000); //irelevant in this case
        try {
            connection.getInputStream();
        } catch (SocketTimeoutException stx) {
            assertEquals(stx.getMessage(), "connect timed out"); //that's what are we waiting for
        }
    }
}
