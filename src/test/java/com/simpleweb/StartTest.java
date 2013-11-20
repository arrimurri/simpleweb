package com.simpleweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StartTest {

    @Test
    public void startApplication() throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();

        handler.addServletWithMapping(SimpleWeb.class, "/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }

}
