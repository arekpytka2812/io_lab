package org.io.DAOs;

import java.util.List;

public class Line {

    private List<BusStop> route;
    private int lineNumber;

    public Line(List<BusStop> route, int lineNumber){
        this.route = route;
        this.lineNumber = lineNumber;
    }

    public List<BusStop> getRoute(){
        return route;
    }
}
