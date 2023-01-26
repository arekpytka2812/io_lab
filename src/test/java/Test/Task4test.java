package Test;

import org.io.DAOs.User;
import org.io.DAOs.UserType;
import org.io.Utils.AuthUtil;
import org.junit.Before;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Category({FactoryTest.class})
public class Task4test {

    List<User> correctUserList = new ArrayList<>();
    List<User> incorrectUserList = new ArrayList<>();

    @BeforeAll
    public void setup() {

        // setting up correct users
        correctUserList.add(new User("admin", "test", UserType.Admin));
        correctUserList.add(new User("test", "haslo", UserType.Driver));
        correctUserList.add(new User("bus234", "bus234pass", UserType.Bus));
        correctUserList.add(new User("disNr123", "disNr123pass", UserType.Dispatcher));
        correctUserList.add(new User("board1", "board1pass", UserType.Board));


        // setting up incorrect users
        incorrectUserList.add(new User("admin", "tets", UserType.Admin));
        incorrectUserList.add(new User("test", "maslo", UserType.Driver));
        incorrectUserList.add(new User("bus234", "niepoprawnehaslo", UserType.Bus));
        incorrectUserList.add(new User("disNr123", "disNr123tyutpass", UserType.Dispatcher));
        incorrectUserList.add(new User("board1", "board1rteypass", UserType.Board));

    }

    @Test
    @Category({AuthTest.class})
    @DisplayName("Auth test / Correct credentials")
    public void testCorrectCredentials(){

        for(User element : correctUserList){

            // asserting that there is such user in database
            Assertions.assertTrue(AuthUtil.authenticate(element.getUsername(), element.getPassword()));
        }
    }

    @Test
    @Category({AuthTest.class})
    @DisplayName("Auth test / Incorrect credentials")
    public void testIncorrectCredentials(){

        for(User element : incorrectUserList){

            // asserting that there is such user in database
            Assertions.assertFalse(AuthUtil.authenticate(element.getUsername(), element.getPassword()));
        }
    }

    @Test
    @Category({AuthTest.class})
    @DisplayName("UserType Test")
    public void testUserType(){

        for(User element : correctUserList){

            // logging into current session
            AuthUtil.authenticate(element.getUsername(), element.getPassword());

            // asserting that userType is correct in current session
            Assertions.assertEquals(AuthUtil.getUserType(), element.getUserType());
        }
    }
}
