package com.simpleweb;

import com.simpleweb.route.Route;
import com.simpleweb.route.SimpleRoute;
import com.simpleweb.templatehandlers.JspTemplateDispatcher;
import com.simpleweb.templatehandlers.TemplateHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ConcurrentLinkedQueue;

@RunWith(JUnit4.class)
public class StartTest {

    public static class TestClass extends SimpleWeb {
        @Override
        public ConcurrentLinkedQueue<Route> getRoutes() {
            ConcurrentLinkedQueue<Route> routes = new ConcurrentLinkedQueue<>();

            routes.add(new SimpleRoute("", "index.jsp"));
            routes.add(new SimpleRoute("home", "index.jsp"));

            return routes;
        }

        @Override
        public TemplateHandler getTemplateHandler() {
            return new JspTemplateDispatcher();
        }
    }

    @Test
    public void startApplication() throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();

        handler.addServletWithMapping(TestClass.class, "/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }

}
