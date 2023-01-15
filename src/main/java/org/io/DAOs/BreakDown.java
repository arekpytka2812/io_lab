package org.io.DAOs;

public class BreakDown {

    private static int breakdownCounter = 0;

    private final int ID;
    private final int brokenBusID;
    private final BreakDownType type;
    private final int busXPosition, busYPosition;

    private BreakDownStatus status = BreakDownStatus.TO_BE_RESOLVED;

    public BreakDown(int brokenBusID, int busXPosition, int busYPosition, BreakDownType type){
        this.ID = breakdownCounter++;
        this.brokenBusID = brokenBusID;
        this.busXPosition = busXPosition;
        this.busYPosition = busYPosition;
        this.type = type;
    }

    public int getID(){
        return ID;
    }

    public int getBrokenBusID(){
        return brokenBusID;
    }

    public int getBusXPosition(){
        return busXPosition;
    }

    public int getBusYPosition(){
        return busYPosition;
    }

    public BreakDownType getType(){
        return type;
    }

    public BreakDownStatus getStatus(){
        return status;
    }

    public void setStatus(BreakDownStatus newStatus){
        status = newStatus;
    }

    @Override
    public String toString(){
        return "ID:_" + ID + "_BrokenBus_" + brokenBusID + "_Type:_" + type + "_Status:_" + status;
    }
}
