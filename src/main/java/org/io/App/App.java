package main.java.org.io.App;

import main.java.org.io.Utils.*;


public class App {
    static Users userType = Users.Unlogged;
    static DispatchUtil dispatchService;
    static AdminUtil adminService;
    static AuthUtil authUtil;

    public static void run(){
        runLoginWindow();
        openMainWindow();
    }

    private static void runLoginWindow(){
        String username = "admin", password = "pass";

        do {
            userType = AuthUtil.getUserType(username);
        } while(AuthUtil.authenticate(username, password));
    }

    private static void openMainWindow(){
        switch (userType) {
            case Admin:
                openAdminWindow();
                break;

            case Dispatcher:
                openDispatcherWindow();
                break;

            case Driver:
                openDriverWindow();
                break;

        }
    }

    private static void openAdminWindow(){}
    private static void openDispatcherWindow(){

    }
    private static void openDriverWindow(){}
}