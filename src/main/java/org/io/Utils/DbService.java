package main.java.org.io.Utils;

import main.java.org.io.DAOs.*;

import java.util.ArrayList;
import java.util.List;


public class DbService{

    List<Bus> busList;
    List<BusStop> busStopList;
    List<Line> lineList;
    List<BreakDown> breakDownList;

    public DbService(){
        this.busList = new ArrayList<>();
        this.busStopList = new ArrayList<>();
        this.lineList = new ArrayList<>();
        this.breakDownList = new ArrayList<>();

        initializeData();
    }

    private void initializeData(){
        // TODO dodanie jakis obiektow
    }

    public void insertBus(Bus bus){
        busList.add(bus);
    }

    public void insertStop(BusStop busStop){
        busStopList.add(busStop);
    }

    public void insertLine(Line line){
        lineList.add(line);
    }

    public List<BusStop> getStops(){
        return busStopList;
    }

    public BreakDown getBreakDownInfo(int index) {
        return breakDownList.get(index);
    }

    public List<Bus> getAvailableBuses() {
        List<Bus> availableBuses = new ArrayList<>();

        for(Bus bus : busList){
            if(bus.getStatus() == BusStatus.Available){
                availableBuses.add(bus);
            }
        }

        return availableBuses;
    }

    public void reportFailure(BreakDown breakDown) {
        breakDownList.add(breakDown);
    }

    public void changeBusStatus(int id, BusStatus newStatus){
        for(Bus bus : busList) {
            if (bus.getID() == id) {
                bus.setStatus(newStatus);
                return;
            }
        }
    }

    public void updateBusPosition(int id, double posX, double posY){
        for(Bus bus : busList) {
            if (bus.getID() == id) {
                bus.setPosX(posX);
                bus.setPosX(posY);
                return;
            }
        }
    }
}
