package main.java.org.io.Utils;

import main.java.org.io.DAOs.*;

import java.util.List;

public class DispatchUtil extends Util {

    public static List<BreakDown> getBreakDowns(){
        return dbService.getBreakDownList();
    }

    public static List<BreakDown> getUnresolvedBreakDowns(){
        return dbService.getUnresolvedBreakDownList();
    }

    public static List<Bus> getAvailableBuses(){
        return dbService.getAvailableBuses();
    }

    public static void sendReplacementBus(Bus chosenBus, BreakDown resolvedBreakdown){

        //var brokenBusInfo = dbService.getBreakDownInfo();
        dbService.changeBusStatus(chosenBus, BusStatus.OnRoute);
        dbService.changeBreakDownStatus(resolvedBreakdown, BreakDownStatus.RESOLVED);
    }

}
