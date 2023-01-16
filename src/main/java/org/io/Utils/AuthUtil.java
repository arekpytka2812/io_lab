package org.io.Utils;

import org.io.DAOs.User;
import org.io.DAOs.UserType;

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
