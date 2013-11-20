package com.simpleweb;

import com.simpleweb.route.Route;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;


public class SimpleWeb extends HttpServlet {

    private ConcurrentLinkedQueue<Route> routes = new ConcurrentLinkedQueue<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!routes.isEmpty()) {
            for (Route route : routes) {
                if (route.matches(req.getRequestURI())) {
                    RequestDispatcher dispatcher = req.getRequestDispatcher(route.getTarget());
                    dispatcher.forward(req, resp);
                }
            }
        }

    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }

    public ConcurrentLinkedQueue<Route> getRoutes() {
        return routes;
    }

}
