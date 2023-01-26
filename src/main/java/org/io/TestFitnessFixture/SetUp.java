package org.io.TestFitnessFixture;
import fit.Fixture;
import org.io.App.App;
import org.io.DAOs.Bus;
import org.io.DAOs.BusStatus;
import org.io.DAOs.BusStop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SetUp extends Fixture{

    static App app;
    static List<List<BusStop>> routesList = new ArrayList<>();

    public SetUp() {
        app = new App();

        app.addStop(new BusStop(1, "Galeria"));
        app.addStop(new BusStop(2, "Muzeum"));
        app.addStop(new BusStop(3, "Sklep Budowlany"));
        app.addStop(new BusStop(4, "Uczelnia"));
        app.addStop(new BusStop(5, "Politechnika"));
        app.addStop(new BusStop(6, "Rondo"));

        List<BusStop> stops = SetUp.app.getStops();

        routesList.add(new ArrayList<>());
        routesList.get(0).addAll(Arrays.asList(stops.get(1), stops.get(2), stops.get(0), stops.get(3)));

        routesList.add(new ArrayList<>());
        routesList.get(1).addAll(Arrays.asList(stops.get(0), stops.get(1), stops.get(2), stops.get(3)));

        routesList.add(new ArrayList<>());
        routesList.get(2).addAll(Arrays.asList(stops.get(2), stops.get(3), stops.get(0), stops.get(0)));

        routesList.add(new ArrayList<>());
        routesList.get(3).addAll(Arrays.asList(stops.get(3), stops.get(0), stops.get(1), stops.get(2)));

        routesList.add(new ArrayList<>());
        routesList.get(4).addAll(Arrays.asList(stops.get(3), stops.get(2), stops.get(0), stops.get(1)));
    }
}
