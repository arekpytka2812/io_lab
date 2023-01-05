package main.java.org.io.Utils;

import main.java.org.io.App.Users;

public class AuthUtil extends Util {
    public static boolean authenticate(String username, String password){
        return true;
    }

    public static Users getUserType(String username){
        return Users.Admin;
    }

}
