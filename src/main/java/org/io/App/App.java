package org.io.App;

import org.io.DAOs.*;
import org.io.Utils.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;


public class App {

    private static UserType USERTYPE = UserType.Unlogged;
    private static Scanner SCANNER = new Scanner(System.in);

    public void run(){
        runLoginWindow();
        openMainWindow();
    }

    private void runLoginWindow(){
        String username = null, password = null;

        do{
            System.out.println("Type username: ");
            username = SCANNER.nextLine();
            System.out.println("Type password: ");
            password = SCANNER.nextLine();

        } while(!AuthUtil.authenticate(username, password));

        USERTYPE = AuthUtil.getUserType();


    }

    private void openMainWindow(){
        switch (USERTYPE) {
            case Admin:
                openAdminWindow();
                break;

            case Dispatcher:
                openDispatcherWindow();
                break;

            case Driver:
                openDriverWindow();
                break;

            case Bus:
                openBusWindow();
                break;

        }
    }

    private void openAdminWindow(){

    }

    private void openDispatcherWindow(){

    }

    private void openDriverWindow(){

    }

    private void openBusWindow(){

    }

    public void addBus(Bus bus){
        AdminUtil.addBus(bus);
    }

    public void addStop(BusStop busStop){
        AdminUtil.addStop(busStop);
    }

    public void addline(Line line) {AdminUtil.addLine(line);}

    public List<Bus> getBusList(){
        return DispatchUtil.getBusList();
    }

    public List<Bus> getAvailableBuses(){
        return DispatchUtil.getAvailableBuses();
    }

    public List<BusStop> getStops(){
        return DispatchUtil.getStops();
    }

    public List<Line> getLines() {return DispatchUtil.getLines();}
}
