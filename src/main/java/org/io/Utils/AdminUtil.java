package org.io.Utils;

import org.io.DAOs.Bus;
import org.io.DAOs.BusStop;
import org.io.DAOs.Line;
import org.io.DAOs.User;


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

    public static void addUser(User user){
        dbService.insertUser(user);
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
