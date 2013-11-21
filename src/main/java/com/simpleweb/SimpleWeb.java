package com.simpleweb;

import com.simpleweb.route.Route;
import com.simpleweb.templatehandlers.TemplateHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;


public abstract class SimpleWeb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getTemplateHandler().findAndDispatch(getRoutes(), req, resp);

    }

    public abstract ConcurrentLinkedQueue<Route> getRoutes();

    public abstract TemplateHandler getTemplateHandler();

}
