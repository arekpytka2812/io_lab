package main.java.org.io.DAOs;

public class User {

    private final String username;
    private final String password;
    private final UserType userType;

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public boolean compareUsernameAndPassword(String username, String password){

        if(this.username.equals(username) && this.password.equals(password))
            return true;

        return false;
    }

    public UserType getUserType() {
        return userType;
    }
}
