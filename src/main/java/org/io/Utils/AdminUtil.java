package main.java.org.io.Utils;

import main.java.org.io.DAOs.Bus;
import main.java.org.io.DAOs.BusStop;
import main.java.org.io.DAOs.Line;


public class AdminUtil extends Util {

    public static void addBus(Bus bus){

        try{
            dbService.insertBus(bus);
            System.out.println("Bus insert successful");
        }
        catch (Exception e){
            System.out.println("Bus insert failed");
        }
    }

    public static void addStop(BusStop busStop) {
        try{
            dbService.insertStop(busStop);
            System.out.println("Stop insert successful");
        }
        catch (Exception e){
            System.out.println("Stop insert failed");
        }
    }

    public static void addLine(Line line){
        try{
            dbService.insertLine(line);
            System.out.println("Line insert successful");
        }
        catch(Exception e){
            System.out.println("Line insert failed");
        }
    }

    public static void replaceBus(Bus bus){

    }

    public static void replaceStop(BusStop busStop) {

    }

    public static void replaceLine(Line line){

    }

    public static void removeBus(Bus bus){

    }

    public static void removeStop(BusStop busStop) {

    }

    public static void removeLine(Line line){

    }
}
