package com.simpleweb.route;


public interface Route {

    boolean matches(String uri);

    String getTarget();

}
