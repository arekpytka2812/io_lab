package org.io.App;

import org.io.DAOs.*;
import org.io.Utils.*;

import java.util.Scanner;


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
}
