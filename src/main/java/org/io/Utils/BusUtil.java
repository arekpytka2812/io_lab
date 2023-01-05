package main.java.org.io.Utils;

import main.java.org.io.DAOs.BreakDown;

public class BusUtil extends Util{

    public static void reportFailure(BreakDown breakDown) {
        dbService.reportFailure(breakDown);
    }

    private static void updatePosition(int id, double posX, double posY){
        dbService.updateBusPosition(id, posX, posY);
    }

}
