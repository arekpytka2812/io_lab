package org.io.Utils;

import org.io.DAOs.BreakDown;
import org.io.DAOs.Bus;
import org.io.DAOs.BusStatus;

public class BusUtil extends Util{

    public static void reportFailure(BreakDown breakDown) {
        dbService.reportFailure(breakDown);
        dbService.changeBusStatus(breakDown.getBrokenBusID(), BusStatus.Broken);
    }

    private static void updatePosition(Bus chosenBus, double posX, double posY){
        dbService.updateBusPosition(chosenBus, posX, posY);
    }

}
