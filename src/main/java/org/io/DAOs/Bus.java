package main.java.org.io.DAOs;

public class Bus {

    private final int ID;
    private double posX = 0, posY = 0;
    private BusStatus status = BusStatus.Available;

    public Bus(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public BusStatus getStatus() {
        return status;
    }

    public void setStatus(BusStatus status) {
        this.status = status;
    }
}