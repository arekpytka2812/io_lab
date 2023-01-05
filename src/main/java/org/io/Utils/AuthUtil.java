package main.java.org.io.Utils;

import main.java.org.io.DAOs.User;
import main.java.org.io.DAOs.UserType;

public class AuthUtil extends Util {

    static User loggedUser = null;

    public static boolean authenticate(String username, String password){
        loggedUser = dbService.getUser(username, password);

        return loggedUser != null;
    }

    public static UserType getUserType(){
        return loggedUser.getUserType();
    }

}
