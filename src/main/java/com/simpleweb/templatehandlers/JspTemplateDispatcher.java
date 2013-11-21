package com.simpleweb.templatehandlers;

import com.simpleweb.route.Route;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Queue;


public class JspTemplateDispatcher implements TemplateHandler {

    @Override
    public void findAndDispatch(Queue<Route> routes, HttpServletRequest req, HttpServletResponse resp) {
        try (Writer writer = resp.getWriter()) {
            writer.write("request uri: " + req.getRequestURI() + "<br/>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!routes.isEmpty()) {
            System.out.println("Routes is not empty");
            for (Route route : routes) {
                if (route.matches(cleanup(req.getRequestURI()))) {
                    System.out.println("Route: " + route + ", matches request uri: " + req.getRequestURI());
                    RequestDispatcher dispatcher = req.getRequestDispatcher(route.getTarget());
                    try {
                        System.out.println("Forwarding...");
                        dispatcher.forward(req, resp);
                    } catch (ServletException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private String cleanup(String requestURI) {
        String retString = requestURI;
        if (requestURI.startsWith("/")) {
            retString = retString.substring(1);
        }
        if (retString.endsWith("/")) {
            retString.substring(0, retString.length() - 1);
        }

        return retString;
    }
}
