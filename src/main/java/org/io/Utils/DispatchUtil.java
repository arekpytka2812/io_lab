package main.java.org.io.Utils;

import main.java.org.io.DAOs.Bus;
import main.java.org.io.DAOs.BusStatus;

import java.util.List;

public class DispatchUtil extends Util {

    public static void sendReplacementBus(){

        //var brokenBusInfo = dbService.getBreakDownInfo();
        var availableBuses = dbService.getAvailableBuses();

        if(availableBuses.isEmpty())
            return;

        var chosenBusID = chooseBus(availableBuses);

        dbService.changeBusStatus(chosenBusID, BusStatus.OnRoute);

    }

    private static int chooseBus(List<Bus> busList) {
        System.out.println("Choosing bus...");
        return 0;
    }


}
