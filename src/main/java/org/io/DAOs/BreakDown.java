package main.java.org.io.DAOs;

public class BreakDown {

    private static int breakdownCounter = 0;

    private final int ID;
    private int brokenBusID;
    private int busXPosition, busYPosition;

    private BreakDownType type;

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
}
