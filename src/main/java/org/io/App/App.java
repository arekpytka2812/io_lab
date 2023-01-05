package main.java.org.io.App;

import main.java.org.io.DAOs.UserType;
import main.java.org.io.Utils.*;

import java.util.Scanner;


public class App {

    private static UserType USERTYPE = UserType.Unlogged;
    private static Scanner SCANNER = new Scanner(System.in);

    public static void run(){
        runLoginWindow();
        openMainWindow();
    }

    private static void runLoginWindow(){
        String username = null, password = null;

        do{
            System.out.println("Type username: ");
            username = SCANNER.nextLine();
            System.out.println("Type password: ");
            password = SCANNER.nextLine();

        } while(!AuthUtil.authenticate(username, password));

        USERTYPE = AuthUtil.getUserType();
    }

    private static void openMainWindow(){
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

    private static void openAdminWindow(){

    }

    private static void openDispatcherWindow(){

    }

    private static void openDriverWindow(){

    }

    private static void openBusWindow(){

    }
}
