package com.simpleweb.route;


public class SimpleRoute implements Route {

    private final String route;
    private final String target;

    SimpleRoute(String route, String target) {
        this.route = route;
        this.target = target;
    }

    @Override
    public boolean matches(String uri) {
        return route.equals(uri);
    }

    @Override
    public String getTarget() {
        return target;
    }


}
