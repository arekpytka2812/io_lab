package Test.Mocked;

import mockit.Mocked;
import org.io.DAOs.*;
import org.io.Utils.AdminUtil;
import org.io.Utils.AuthUtil;
import org.io.Utils.BusUtil;
import org.io.Utils.DispatchUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.experimental.categories.Category;

@Category({MockedTest.class})
public class UserAuthMockedTest {

    @Mocked
    static User user = new User("ernest", "pytka", UserType.Driver);

    @Before
    public void setup(){
        AdminUtil.addUser(user);
    }

    @Test
    public void userAuthMockedTest(){
        Assertions.assertTrue(AuthUtil.authenticate(user.getUsername(), user.getPassword()));
    }

    @Test
    public void loggedUserTypeTest(){
        Assertions.assertEquals(UserType.Driver, user.getUserType());
    }

}
