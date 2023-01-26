package org.io.Utils;

import org.io.DAOs.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbService{
    Map<String, User> usersMap;
    List<Bus> busList;
    List<BusStop> busStopList;
    List<Line> lineList;
    List<BreakDown> breakDownList;

    public DbService(){
        this.usersMap = new HashMap<>();

        this.busList = new ArrayList<>();
        this.busStopList = new ArrayList<>();
        this.lineList = new ArrayList<>();
        this.breakDownList = new ArrayList<>();

        initializeData();
    }

    private void initializeData(){

        usersMap.put("admin", new User("admin", "test", UserType.Admin));
        usersMap.put("test", new User("test", "haslo", UserType.Driver));
        usersMap.put("bus234", new User("bus234", "bus234pass", UserType.Bus));
        usersMap.put("disNr123", new User("disNr123", "disNr123pass", UserType.Dispatcher));
        usersMap.put("board1", new User("board1", "board1pass", UserType.Board));

    }

    public User getUser(String username, String password){

        if(!usersMap.containsKey(username))
            return null;

        if(!usersMap.get(username).compareUsernameAndPassword(username, password)){
            return null;
        }

        return usersMap.get(username);
    }

    public List<Bus> getBusList(){
        return this.busList;
    }

    public void insertUser(User user){
        this.usersMap.put(user.getUsername(), user);
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

    public List<Line> getLines(){
        return lineList;
    }


    public BreakDown getBreakDownInfo(int index) {
        return breakDownList.get(index);
    }

    public List<BreakDown> getBreakDownList(){
        return breakDownList;
    }

    public List<BreakDown> getUnresolvedBreakDownList(){
        List<BreakDown> returnList = new ArrayList<>();

        for(BreakDown breakdown : breakDownList){
            if(breakdown.getStatus() == BreakDownStatus.TO_BE_RESOLVED)
                returnList.add(breakdown);
        }

        return returnList;
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

    public void changeBusStatus(Bus chosenBus, BusStatus newStatus){
        for(Bus bus : busList) {
            if (bus.getID() == chosenBus.getID()){
                bus.setStatus(newStatus);
                return;
            }
        }
    }

    public void changeBusStatus(final int ID, BusStatus newStatus){
        for(Bus bus : busList) {
            if (bus.getID() == ID){
                bus.setStatus(newStatus);
                return;
            }
        }
    }

    public void updateBusPosition(Bus chosenBus, double posX, double posY){
        for(Bus bus : busList) {
            if (bus.getID() == chosenBus.getID()) {
                bus.setPosX(posX);
                bus.setPosY(posY);
                return;
            }
        }
    }

    public void changeBreakDownStatus(BreakDown resolvedBreakdown, BreakDownStatus newStatus){
        for(BreakDown breakDown : breakDownList) {
            if (breakDown.getID() == resolvedBreakdown.getID()) {
                breakDown.setStatus(newStatus);
                return;
            }
        }
    }
}
