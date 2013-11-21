package com.simpleweb.templatehandlers;


import com.simpleweb.route.Route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Queue;

public interface TemplateHandler {

    void findAndDispatch(Queue<Route> routes, HttpServletRequest req, HttpServletResponse resp);

}
