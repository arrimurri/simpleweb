package com.simpleweb.route;


public class SimpleRoute implements Route {

    private final String route;
    private final String target;

    public SimpleRoute(String route, String target) {
        this.route = route;
        this.target = target;
    }

    @Override
    public boolean matches(String uri) {
        System.out.println(route + " matches " + uri);
        return route.equals(uri);
    }

    @Override
    public String getTarget() {
        return target;
    }


}
